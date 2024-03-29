package com.etiya.rentacar.business.dtos.requests.rentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalBranchRequest {

    private int id;

    private String name;

    private int cityId;

}
