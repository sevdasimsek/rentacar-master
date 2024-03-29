package com.etiya.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCustomerResponse {

    private int id;

    private String userName;

    private String firstName;

    private String lastName;

    private String nationalId;

    private String email;

    private String password;

    private String companyName;

    private LocalDateTime updatedDate;
}

