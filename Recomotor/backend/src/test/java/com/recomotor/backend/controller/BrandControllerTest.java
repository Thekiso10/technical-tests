package com.recomotor.backend.controller;

import com.recomotor.backend.dto.BrandDto;
import com.recomotor.backend.service.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandControllerTest {

    @Mock
    private BrandServiceImpl brandService;

    @InjectMocks
    private BrandController brandController;

    @Test
    void testGetCars() {
        BrandDto brandDto1 = new BrandDto();
        BrandDto brandDto2 = new BrandDto();
        List<BrandDto> brandDtoList = Arrays.asList(brandDto1, brandDto2);

        when(brandService.getAll()).thenReturn(brandDtoList);

        ResponseEntity<List<BrandDto>> responseEntity = brandController.getCars();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().contains(brandDto1));
        assertTrue(responseEntity.getBody().contains(brandDto2));
    }
}
