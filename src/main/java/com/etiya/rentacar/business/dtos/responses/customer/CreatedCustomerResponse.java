package com.etiya.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCustomerResponse {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String companyName;
}
