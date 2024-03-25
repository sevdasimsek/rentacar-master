package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelListResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.UpdatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
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

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = modelMapperService.forResponse().map(createFuelRequest, Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel savedFuel = fuelRepository.save(fuel);
        return modelMapperService.forResponse().map(savedFuel, CreatedFuelResponse.class);

    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel fuel = findById(updateFuelRequest.getId());
        fuel.setName(updateFuelRequest.getName());
        fuel.setUpdatedDate(LocalDateTime.now());
        Fuel savedFuel = fuelRepository.save(fuel);
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
        Fuel fuel = findById(id);
        return modelMapperService.forResponse().map(fuel, GetFuelResponse.class);
    }

    @Override
    public void delete(int id) {
        Fuel fuel = findById(id);
        fuel.setDeletedDate(LocalDateTime.now());
        fuelRepository.save(fuel);
    }

    private Fuel findById(int id) {
        return fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }

}
