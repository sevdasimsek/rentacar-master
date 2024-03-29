package com.etiya.rentacar.business.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetModelResponse {

    private int id;

    private String name;

    private String brandName;

    private String transmissionName;

    private String fuelName;

}
