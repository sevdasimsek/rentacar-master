package com.etiya.rentacar.business.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedCityResponse {
    private String name;
    private LocalDateTime deletedDate;
}
