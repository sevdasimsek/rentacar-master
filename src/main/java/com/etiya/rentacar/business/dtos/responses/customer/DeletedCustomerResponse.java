package com.etiya.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCustomerResponse {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String email;
    private String password;
    private String companyName;
    private LocalDateTime deletedDate;
}
