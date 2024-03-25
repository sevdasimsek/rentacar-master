package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelListResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.UpdatedFuelResponse;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = new Fuel();
        fuel.setName(createFuelRequest.getName());
        fuelRepository.save(fuel);

        CreatedFuelResponse response = new CreatedFuelResponse();
        response.setId(fuel.getId());
        response.setName(fuel.getName());
        response.setCreatedDate(fuel.getCreatedDate());

        return response;


    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel fuel = fuelRepository.findById(updateFuelRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Fuel not found"));
        fuel.setName(updateFuelRequest.getName());
        fuelRepository.save(fuel);

        UpdatedFuelResponse response = new UpdatedFuelResponse();
        response.setId(fuel.getId());
        response.setName(fuel.getName());
        response.setUpdatedDate(fuel.getUpdatedDate());

        return response;
    }

    @Override
    public GetFuelResponse getById(int id) {
        Fuel fuel = fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fuel not found"));
        GetFuelResponse response = new GetFuelResponse();
        response.setId(fuel.getId());
        response.setName(fuel.getName());
        return response;
    }

    @Override
    public List<GetFuelListResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetFuelListResponse> response = fuels.stream().map(fuel -> new GetFuelListResponse(fuel.getId(), fuel.getName())).toList();
        return response;
    }

    @Override
    public Fuel getByFuelId(int id) {

        Fuel fuel = fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fuel not found"));
        return fuel;
    }

    @Override
    public void delete(int id) {

        fuelRepository.deleteById(id);

    }


}
