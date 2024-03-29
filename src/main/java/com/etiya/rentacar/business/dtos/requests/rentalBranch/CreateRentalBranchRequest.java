package com.etiya.rentacar.business.dtos.requests.rentalBranch;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalBranchRequest {

    @NotEmpty(message = "Rental Branch name cannot be blank")
    @NotBlank(message = "Rental Branch name cannot be empty")
    private String name;

    private int cityId;
}
