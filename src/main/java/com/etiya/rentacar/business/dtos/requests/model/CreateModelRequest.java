package com.etiya.rentacar.business.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    private String name;

    private int brandId;

    private int fuelId;

    private int transmissionId;

}
