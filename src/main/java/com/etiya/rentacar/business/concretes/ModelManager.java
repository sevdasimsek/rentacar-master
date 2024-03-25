package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.etiya.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.etiya.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelListResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Fuel;
import com.etiya.rentacar.entities.Model;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private FuelService fuelService;
    private TransmissionService transmissionService;
    private BrandService brandService;


    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Model model = new Model();

        Fuel fuel = fuelService.getByFuelId(createModelRequest.getFuelId());
        Transmission transmission = transmissionService.getByTransmissionId(createModelRequest.getTransmissionId());
        Brand brand = brandService.getByBrandId(createModelRequest.getBrandId());

        model.setName(createModelRequest.getName());
        model.setFuel(fuel);
        model.setTransmission(transmission);
        model.setBrand(brand);

        modelRepository.save(model);

        CreatedModelResponse response = new CreatedModelResponse();
        response.setId(model.getId());
        response.setName(model.getName());
        response.setBrandId(model.getBrand().getId());
        response.setFuelId(model.getFuel().getId());
        response.setTransmissionId(model.getTransmission().getId());
        response.setCreatedDate(model.getCreatedDate());

        return response;
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        Model model = modelRepository.findById(updateModelRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Model not found"));
        Fuel fuel = fuelService.getByFuelId(updateModelRequest.getFuelId());
        Transmission transmission = transmissionService.getByTransmissionId(updateModelRequest.getTransmissionId());
        Brand brand = brandService.getByBrandId(updateModelRequest.getBrandId());

        model.setName(updateModelRequest.getName());
        model.setFuel(fuel);
        model.setTransmission(transmission);
        model.setBrand(brand);
        modelRepository.save(model);


        UpdatedModelResponse response = new UpdatedModelResponse();
        response.setId(model.getId());
        response.setName(model.getName());
        response.setBrandId(model.getBrand().getId());
        response.setFuelId(model.getFuel().getId());
        response.setTransmissionId(model.getTransmission().getId());
        response.setUpdatedDate(model.getUpdatedDate());
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {

        Model model = modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model not found"));
        GetModelResponse response = new GetModelResponse();
        response.setId(model.getId());
        response.setName(model.getName());
        response.setBrandId(model.getBrand().getId());
        response.setFuelId(model.getFuel().getId());
        response.setTransmissionId(model.getTransmission().getId());
        return response;
    }

    @Override
    public List<GetModelListResponse> getAll() {

        List<Model> models = modelRepository.findAll();
        List<GetModelListResponse> response = models.stream().map(model -> new GetModelListResponse(model.getId(), model.getName(), model.getBrand().getId(), model.getFuel().getId(), model.getTransmission().getId())).toList();
        return response;
    }

    @Override
    public Model getByModelId(int id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model not found"));
        return model;
    }

    @Override
    public void delete(int id) {

        modelRepository.deleteById(id);

    }
}
