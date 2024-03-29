package com.etiya.rentacar.business.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCityListResponse {

    private int id;

    private String name;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
