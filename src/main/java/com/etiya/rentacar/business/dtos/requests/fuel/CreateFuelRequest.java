package com.etiya.rentacar.business.dtos.requests.fuel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateFuelRequest {

    @NotEmpty(message = "Fuel name cannot be empty")
    @Size(min = 2, max = 30)
    private String name;

}
