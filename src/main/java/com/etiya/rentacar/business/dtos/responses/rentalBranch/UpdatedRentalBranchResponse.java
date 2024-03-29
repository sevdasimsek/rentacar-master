package com.etiya.rentacar.business.dtos.responses.rentalBranch;

import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.City;
import com.etiya.rentacar.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedRentalBranchResponse {
    private int id;

    private String name;

    private int cityId;

    private String cityName;

    private LocalDateTime updatedDate;
}
