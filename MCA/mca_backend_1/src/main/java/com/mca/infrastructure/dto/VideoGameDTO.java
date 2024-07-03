package com.mca.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class VideoGameDTO {

    private String id;

    private String title;

    private BigDecimal price;

    private Boolean availability;

    public VideoGameDTO(Long id, String title, BigDecimal price, Boolean availability) {
        this.id = String.valueOf(id);
        this.title = title;
        this.price = price;
        this.availability = availability;
    }
}
