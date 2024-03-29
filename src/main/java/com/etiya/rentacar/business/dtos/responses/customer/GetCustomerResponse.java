package com.etiya.rentacar.business.dtos.responses.customer;

import com.etiya.rentacar.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {

    private int id;

    private String userName;

    private String firstName;

    private String lastName;

    private String nationalId;

    private String email;

    private String password;

    private String companyName;

    private LocalDateTime createdDate;
}
