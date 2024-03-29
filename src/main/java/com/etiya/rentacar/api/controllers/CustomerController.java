package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerResponse getById(@PathVariable int id){

        return customerService.getById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetCustomerListResponse> getAll(){

        return customerService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.add(createCustomerRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCustomerResponse delete(@PathVariable int id) {
        return customerService.delete(id);
    }
}
