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
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Fuel;
import com.etiya.rentacar.entities.Model;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private FuelService fuelService;
    private TransmissionService transmissionService;
    private BrandService brandService;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model savedModel = modelRepository.save(model);
        return modelMapperService.forResponse().map(savedModel, CreatedModelResponse.class);
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        Model model = findById(updateModelRequest.getId());
        model.setName(updateModelRequest.getName());
        model.setUpdatedDate(LocalDateTime.now());
        Model savedModel = modelRepository.save(model);
        return modelMapperService.forResponse().map(savedModel, UpdatedModelResponse.class);
    }

    @Override
    public List<GetModelListResponse> getAll() {

        List<Model> models = modelRepository.findAll();
        return models.stream().filter(model -> model.getDeletedDate() == null).map(model ->
                modelMapperService.forResponse().map(model, GetModelListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model = findById(id);
        return modelMapperService.forResponse().map(model, GetModelResponse.class);
    }


    @Override
    public void delete(int id) {
        Model model = findById(id);
        model.setDeletedDate(LocalDateTime.now());
        modelRepository.save(model);
    }

    private Model findById(int id) {
        return modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }
}
