package com.recomotor.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class ModelDto {
    private Long id;
    private String name;
    private String imgUrl;
}
