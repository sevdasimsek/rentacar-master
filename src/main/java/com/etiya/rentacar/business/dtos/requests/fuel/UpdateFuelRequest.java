package com.etiya.rentacar.business.dtos.requests.fuel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFuelRequest {

    private int id;
    @NotEmpty(message ="Brand name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;

}
