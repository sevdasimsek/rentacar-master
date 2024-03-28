package com.etiya.rentacar.business.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private int customerId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private double rentStartKilometer;


}
