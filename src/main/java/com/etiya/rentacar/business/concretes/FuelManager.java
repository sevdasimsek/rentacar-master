package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelListResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.UpdatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.etiya.rentacar.business.rules.FuelBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Fuel;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCannotBeDuplicated(createFuelRequest.getName());
        Fuel fuel = modelMapperService.forResponse().map(createFuelRequest, Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel savedFuel = fuelRepository.save(fuel);
        return modelMapperService.forResponse().map(savedFuel, CreatedFuelResponse.class);

    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        fuelBusinessRules.fuelNameCannotBeDuplicated(updateFuelRequest.getName());
        fuelBusinessRules.fuelIdIsExist(updateFuelRequest.getId());
        Fuel fuel = findById(updateFuelRequest.getId());
        Fuel mappedFuel = modelMapperService.forRequest().map(updateFuelRequest, Fuel.class);
        mappedFuel.setCreatedDate(fuel.getCreatedDate());
        Fuel savedFuel = fuelRepository.save(mappedFuel);
        return modelMapperService.forResponse().map(savedFuel, UpdatedFuelResponse.class);
    }

    @Override
    public List<GetFuelListResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        return fuels.stream().filter(fuel -> fuel.getDeletedDate() == null).map(fuel ->
                modelMapperService.forResponse().map(fuel, GetFuelListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetFuelResponse getById(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        Fuel fuel = findById(id);
        return modelMapperService.forResponse().map(fuel, GetFuelResponse.class);
    }

    @Override
    public void delete(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        Fuel fuel = findById(id);
        fuel.setDeletedDate(LocalDateTime.now());
        fuelRepository.save(fuel);
    }

    private Fuel findById(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        return fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fuel not found"));
    }

}
