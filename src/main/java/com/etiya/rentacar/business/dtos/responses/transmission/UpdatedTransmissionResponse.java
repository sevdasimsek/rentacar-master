package com.etiya.rentacar.business.dtos.responses.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedTransmissionResponse {

    private int id;

    private String name;

    private LocalDateTime updatedDate;
}
