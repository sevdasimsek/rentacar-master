package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.UpdatedCustomerResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CustomerRepository;
import com.etiya.rentacar.entities.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerManager implements CustomerService {
    private ModelMapperService modelMapperService;
    private CustomerRepository customerRepository;

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        Customer mappedCustomer = modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        Customer createdCustomer = customerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(createdCustomer, CreatedCustomerResponse.class);
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findById(updateCustomerRequest.getId());
        Customer mappedCustomer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        mappedCustomer.setCreatedDate(customer.getCreatedDate());
        Customer savedCustomer = customerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(savedCustomer, UpdatedCustomerResponse.class);
    }

    @Override
    public List<GetListCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().filter(customer -> customer.getDeletedDate() == null)
                .map(customer -> modelMapperService.forResponse()
                        .map(customer, GetListCustomerResponse.class)).collect(Collectors.toList());
    }
    public GetCustomerResponse getById(int id) {
        Customer customer = findById(id);
        return modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
    }
    @Override
    public DeletedCustomerResponse delete(int id) {
        Customer customer = findById(id);
        customer.setDeletedDate(LocalDateTime.now());
        customerRepository.save(customer);
        return modelMapperService.forResponse().map(customer, DeletedCustomerResponse.class);
    }

    public Customer findById(int id) {
        //  carBusinessRules.carIdIsExist(id);
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}
