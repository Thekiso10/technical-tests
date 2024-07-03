package com.recomotor.backend.service;

import com.recomotor.backend.dto.BrandDto;
import com.recomotor.backend.entity.Brand;
import com.recomotor.backend.mapper.BrandMapper;
import com.recomotor.backend.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandMapper brandMapper;

    @InjectMocks
    private BrandServiceImpl brandService;

    @Test
    void testGetAll() {
        Brand brand1 = new Brand();
        Brand brand2 = new Brand();
        List<Brand> brandList = Arrays.asList(brand1, brand2);

        BrandDto brandDto1 = new BrandDto();
        BrandDto brandDto2 = new BrandDto();
        List<BrandDto> brandDtoList = Arrays.asList(brandDto1, brandDto2);

        when(brandRepository.findAll()).thenReturn(brandList);
        when(brandMapper.mapToBrandDto(brand1)).thenReturn(brandDto1);
        when(brandMapper.mapToBrandDto(brand2)).thenReturn(brandDto2);

        List<BrandDto> result = brandService.getAll();

        Mockito.verify(brandRepository, Mockito.times(1)).findAll();
        Mockito.verify(brandMapper, Mockito.times(1)).mapToBrandDto(brand1);
        Mockito.verify(brandMapper, Mockito.times(1)).mapToBrandDto(brand2);
        Mockito.verifyNoMoreInteractions(brandRepository, brandMapper);

        assertEquals(brandDtoList, result);
    }
}
