package com.etiya.rentacar.business.dtos.requests.brand;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBrandRequest {
    @NotEmpty(message ="Brand name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;
}