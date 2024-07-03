package com.recomotor.backend.mapper;

import com.recomotor.backend.dto.ModelDto;
import com.recomotor.backend.entity.Model;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelDto mapToModelDto(Model model);

    Model mapToModel(ModelDto modelDto);
}
