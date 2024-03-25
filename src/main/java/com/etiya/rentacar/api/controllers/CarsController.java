package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {

    private CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @PutMapping
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {
        return carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

}
