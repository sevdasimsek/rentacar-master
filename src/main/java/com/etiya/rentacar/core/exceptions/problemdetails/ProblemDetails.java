package com.etiya.rentacar.core.exceptions.problemdetails;

import lombok.Data;

@Data
public class ProblemDetails {
    private String title;
    private String detail;
    private String status;
    private String type;
}
