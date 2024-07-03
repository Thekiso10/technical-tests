package com.recomotor.backend.mapper;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ModelMapper.class})
public interface EmployerMapper {

    EmployerDto mapToEmployerDto(Employer employer);

    Employer mapToEmployer(EmployerDto employerDto);
}
