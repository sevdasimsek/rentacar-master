package com.etiya.rentacar.business.dtos.requests.transmission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTranmissionRequest {
    @NotEmpty(message ="Transmission name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;

}
