package com.etiya.rentacar.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCarResponse {

    private int id;

    private int modelYear;

    private String plate;

    private int state;

    private double dailyPrice;

    private int modelId;

    private String modelName;

    private double kilometer;

    private String rentalBranchName;

    private LocalDateTime createdDate;
}
