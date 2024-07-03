package com.recomotor.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class EmployerDto {
    private Long id;
    private String name;
    private Integer numEmployer;
    private ModelDto favourModel;
}
