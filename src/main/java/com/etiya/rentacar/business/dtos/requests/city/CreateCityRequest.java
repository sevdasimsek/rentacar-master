package com.etiya.rentacar.business.dtos.requests.city;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCityRequest {

    @NotEmpty(message = "name is not empty")
    @NotEmpty(message = "City name cannot be empty")
    @Size(min = 2, max = 30)
    private String name;
}
