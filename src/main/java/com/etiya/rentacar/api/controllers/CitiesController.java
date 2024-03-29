package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.CityService;
import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.city.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@AllArgsConstructor
public class CitiesController {

    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @PutMapping
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest) {
        return cityService.update(updateCityRequest);
    }

    @GetMapping
    public List<GetCityListResponse> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public GetCityResponse getById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @DeleteMapping("/{id}")
    public DeletedCityResponse delete(@PathVariable int id) {
        return cityService.delete(id);
    }


}

