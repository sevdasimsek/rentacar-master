package com.etiya.rentacar.business.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
    private int modelId;

}
