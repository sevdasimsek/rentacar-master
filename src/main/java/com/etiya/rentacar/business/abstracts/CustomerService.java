package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.*;
import com.etiya.rentacar.entities.Customer;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);

    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    List<GetCustomerListResponse> getAll();

    GetCustomerResponse getById(int id);

    DeletedCustomerResponse delete(int id);

    //public Customer findById(int id); ??
}
