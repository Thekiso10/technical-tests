package com.recomotor.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class BrandDto implements Serializable {
    private Long id;
    private String name;
    private Set<ModelDto> modelList = new HashSet<>();
}
