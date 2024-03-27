package com.etiya.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private int id;
    @NotEmpty(message = "Model Year name cannot be empty")
    @Size(min = 4, max = 5)
    private int modelYear;
    @NotEmpty(message = "Plate Year name cannot be empty")
    @Size(min = 2, max = 30)
    private String plate;
    @NotEmpty(message = "State Year name cannot be empty")
    @Size(min = 1, max = 3)
    private int state;
    @NotEmpty(message = "Daily Price Year name cannot be empty")
    @Size(min = 3, max = 30)
    private double dailyPrice;
    @NotEmpty(message = "Kilometer Year name cannot be empty")
    @Size(min = 2, max = 30)
    private double kilometer;
    private int modelId;
}
