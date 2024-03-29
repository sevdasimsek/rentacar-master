package com.etiya.rentacar.business.dtos.responses.rentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedRentalBranchResponse {
    private int id;
    private String name;
    private int cityId;
    private String cityName;
    private LocalDateTime deletedDate;
}
