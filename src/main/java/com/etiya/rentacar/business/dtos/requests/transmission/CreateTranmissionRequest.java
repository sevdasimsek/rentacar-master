package com.etiya.rentacar.business.dtos.requests.transmission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTranmissionRequest {
    @NotEmpty(message ="Transm name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;

}
