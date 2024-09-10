package com.ntt_data.inditex.backend.service;

import com.ntt_data.inditex.backend.dto.PricesDTO;

import java.time.Instant;

public interface PricesService {

    PricesDTO getAvailablePriceByProductAndBrandAndDate(Long productId, Long brandId, Instant date);
}
