package com.etiya.rentacar.business.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedModelResponse {

    private int id;

    private String name;

    private int brandId;

    private int fuelId;

    private int transmissionId;

    private LocalDateTime updatedDate;
}
