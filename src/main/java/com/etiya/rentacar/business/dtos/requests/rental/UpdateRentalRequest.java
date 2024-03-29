package com.etiya.rentacar.business.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalRequest {

    private int id;

    private LocalDate returnDate;

    private int rentEndKilometer;

    private int rentalBranchId;
}
