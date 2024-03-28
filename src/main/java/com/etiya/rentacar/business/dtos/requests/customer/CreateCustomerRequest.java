package com.etiya.rentacar.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String companyName;
}
