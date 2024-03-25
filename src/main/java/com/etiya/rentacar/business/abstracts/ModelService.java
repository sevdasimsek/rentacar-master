package com.etiya.rentacar.business.abstracts;


import com.etiya.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.etiya.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.etiya.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelListResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.etiya.rentacar.entities.Model;

import java.util.List;

public interface ModelService {

    CreatedModelResponse add(CreateModelRequest createModelRequest);
    UpdatedModelResponse update(UpdateModelRequest updateModelRequest);
    GetModelResponse getById(int id);
    List<GetModelListResponse> getAll();
    void delete(int id);
}
