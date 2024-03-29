package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetRentalBranchListResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.UpdatedRentalBranchResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rentalbranches")
@AllArgsConstructor
public class RentalBranchController {

    private RentalBranchService rentalBranchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalBranchResponse add(@Valid @RequestBody CreateRentalBranchRequest createRentalBranchRequest) {
        return rentalBranchService.add(createRentalBranchRequest);
    }

    @PutMapping
    public UpdatedRentalBranchResponse update(@Valid @RequestBody UpdateRentalBranchRequest updateRentalBranchRequest) {
        return rentalBranchService.update(updateRentalBranchRequest);
    }

    @GetMapping
    public List<GetRentalBranchListResponse> getAll() {
        return rentalBranchService.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalBranchResponse getById(@PathVariable int id) {
        return rentalBranchService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        rentalBranchService.delete(id);
    }
}
