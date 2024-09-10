package com.ntt_data.inditex.backend.controller;

import com.ntt_data.inditex.backend.dto.PricesDTO;
import com.ntt_data.inditex.backend.utils.exceptions.BackendException;
import com.ntt_data.inditex.backend.service.PricesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService pricesService;

    @GetMapping("/available")
    public ResponseEntity<PricesDTO> getAvailablePriceByProductAndBrandAndDate(
            @RequestParam @NotNull Long productId,
            @RequestParam @NotNull Long brandId,
            @RequestParam @NotNull Instant date) {
        log.info("Get available price by product: {} and brand: {} and date: {}", productId, brandId, date.toString());
        return new ResponseEntity<>(pricesService.getAvailablePriceByProductAndBrandAndDate(productId, brandId, date), HttpStatus.OK);
    }
}
