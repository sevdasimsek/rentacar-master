package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);

}
