package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.entities.Customer;

public class CustomerManager implements CustomerService {
    private ModelMapperService modelMapperService;
    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {

               return null;
    }
}
