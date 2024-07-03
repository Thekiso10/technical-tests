package com.recomotor.backend.controller;

import com.recomotor.backend.dto.BrandDto;
import com.recomotor.backend.service.Interface.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/brands/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDto>> getCars() {
        log.info("Get List of Brands");
        List<BrandDto> brandDtoList = brandService.getAll();
        return brandDtoList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(brandDtoList);
    }
}
