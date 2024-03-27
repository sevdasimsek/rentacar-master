package com.etiya.rentacar.business.dtos.requests.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    @NotEmpty(message ="Model name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;

    private int brandId;

    private int fuelId;

    private int transmissionId;

}
