package com.etiya.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private int modelYear;

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private String plate;

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private int state;

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private double dailyPrice;

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private int modelId;

    @NotEmpty(message = "model year is not empty")
    @NotBlank(message = "model year is not only spaces")
    private double kilometer;

    private int rentalBranchId;
}
