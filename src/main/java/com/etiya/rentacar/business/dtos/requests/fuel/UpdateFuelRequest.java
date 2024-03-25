package com.etiya.rentacar.business.dtos.requests.fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFuelRequest {

    private int id;

    private String name;

}
