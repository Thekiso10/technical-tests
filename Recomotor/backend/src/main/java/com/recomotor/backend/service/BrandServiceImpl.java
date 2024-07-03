package com.recomotor.backend.service;

import com.recomotor.backend.dto.BrandDto;
import com.recomotor.backend.mapper.BrandMapper;
import com.recomotor.backend.repository.BrandRepository;
import com.recomotor.backend.service.Interface.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map(brandMapper::mapToBrandDto).toList();
    }
}
