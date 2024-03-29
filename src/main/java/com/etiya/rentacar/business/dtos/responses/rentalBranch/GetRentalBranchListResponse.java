package com.etiya.rentacar.business.dtos.responses.rentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetRentalBranchListResponse {

    private int id;

    private String name;

    private LocalDateTime createdDate;

    private int cityId;

    private String cityName;
}
