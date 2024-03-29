package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {
    private RentalService rentalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse add(@RequestBody CreateRentalRequest createRentalRequest) {
        return rentalService.add(createRentalRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GetRentalResponse getById(@PathVariable int id) {

        return rentalService.getById(id);
    }

    @GetMapping
    public List<GetRentalListResponse> getAll() {

        return rentalService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedRentalResponse delete(@PathVariable int id) {

        return rentalService.delete(id);
    }

    @PutMapping
    public UpdatedRentalResponse update(@RequestBody UpdateRentalRequest updateRentalRequest) {
        return rentalService.update(updateRentalRequest);
    }
}
