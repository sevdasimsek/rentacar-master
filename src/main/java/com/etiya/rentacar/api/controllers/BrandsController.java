package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandListResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.etiya.rentacar.core.exceptions.types.InternalServerErrorException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {

    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.add(createBrandRequest);
    }

    @PutMapping
    public UpdatedBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(updateBrandRequest);
    }

    @GetMapping
    public List<GetBrandListResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        throw new InternalServerErrorException("Internal server error exception custom");
        //return brandService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

}
