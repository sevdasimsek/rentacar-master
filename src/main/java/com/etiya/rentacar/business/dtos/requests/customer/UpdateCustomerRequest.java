package com.etiya.rentacar.business.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {

    private int id;

    private String userName;

    private String firstName;

    private String lastName;

    private String nationalId;

    private String email;

    private String password;

    private String companyName;
}
