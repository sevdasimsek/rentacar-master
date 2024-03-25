package com.etiya.rentacar.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
    private int modelId;
    private double kilometer;
}
