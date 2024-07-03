package com.recomotor.backend.mapper;

import com.recomotor.backend.dto.BrandDto;
import com.recomotor.backend.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ModelMapper.class})
public interface BrandMapper {

    BrandDto mapToBrandDto(Brand brand);

    Brand mapToBrand(BrandDto brandDto);
}
