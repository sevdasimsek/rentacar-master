package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.transmission.CreateTranmissionRequest;
import com.etiya.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionListResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transmissions")
public class TransmissionsController {
    private TransmissionService transmissionService;

    @GetMapping
    public List<GetTranmissionListResponse> getAll(){
        return transmissionService.getAll();
    }

    @GetMapping("/{id}")
    public GetTranmissionResponse getById(@PathVariable int id){
        return transmissionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@Valid @RequestBody CreateTranmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }


    @PutMapping
    public UpdatedTransmissionResponse update(@Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return transmissionService.update(updateTransmissionRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        transmissionService.delete(id);
    }


}
