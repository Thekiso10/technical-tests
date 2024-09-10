package com.ntt_data.inditex.backend.service.impl;

import com.ntt_data.inditex.backend.dto.PricesDTO;
import com.ntt_data.inditex.backend.entity.PricesEntity;
import com.ntt_data.inditex.backend.utils.exceptions.BackendException;
import com.ntt_data.inditex.backend.mapper.PricesMapper;
import com.ntt_data.inditex.backend.repository.PricesRepository;
import com.ntt_data.inditex.backend.service.PricesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;
    private final PricesMapper pricesMapper;

    @Override
    public PricesDTO getAvailablePriceByProductAndBrandAndDate(Long productId, Long brandId, Instant date) {
        log.info("Get Price from productId: {}, brandId: {}, date: {}", productId, brandId, date.toString());
        return pricesRepository.findTopByProductAndBrandAndDate(productId, brandId, date)
                .map(pricesMapper::mapToDto)
                .orElseThrow(() -> new BackendException("ProductId, brandId or date specified do not return any valid prices", HttpStatus.BAD_REQUEST));
    }
}
