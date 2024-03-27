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

    @GetMapping("/{id}")
    public GetCityResponse findById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @GetMapping
    public List<GetCityListResponse> findAll() {
        return cityService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse save(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @PutMapping
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest) {
        return cityService.update(updateCityRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedCityResponse delete(@PathVariable int id) {
        return cityService.delete(id);
    }
}

