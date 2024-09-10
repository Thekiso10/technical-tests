package com.ntt_data.inditex.backend.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class PricesDTO {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    private Instant startDate;
    private Instant endDate;
    private Integer price;
    private Integer currency;
}
