package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.etiya.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.etiya.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelListResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelController {

    private ModelService modelService;

    @GetMapping
    public List<GetModelListResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@RequestBody CreateModelRequest createModelRequest){

        return modelService.add(createModelRequest);
    }

    @PutMapping
    public UpdatedModelResponse update(@RequestBody UpdateModelRequest updateModelRequest){
        return modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }
}
