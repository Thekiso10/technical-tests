package com.recomotor.backend.service;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.entity.Model;
import com.recomotor.backend.mapper.EmployerMapper;
import com.recomotor.backend.repository.EmployerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployerServiceTest {

    @Mock
    private EmployerRepository employerRepository;

    @Mock
    private EmployerMapper employerMapper;

    @InjectMocks
    private EmployerServiceImpl employerService;

    @Test
    void testUpdateFavourModel() {
        Long employerId = 1L;

        Employer employer = new Employer();
        Model model = new Model();

        Mockito.when(employerRepository.findById(employerId)).thenReturn(Optional.of(employer));
        Mockito.when(employerRepository.save(employer)).thenReturn(employer);
        Mockito.when(employerMapper.mapToEmployerDto(employer)).thenReturn(new EmployerDto());

        Optional<Employer> employerOptional = employerService.getEmployerById(employerId);
        Optional<Model> modelOptional = Optional.of(model);
        EmployerDto employerDto = employerService.updateFavourModel(employerOptional, modelOptional);

        Mockito.verify(employerRepository, Mockito.times(1)).findById(employerId);
        Mockito.verify(employerRepository, Mockito.times(1)).save(employer);
        Mockito.verify(employerMapper, Mockito.times(1)).mapToEmployerDto(employer);
        Mockito.verifyNoMoreInteractions(employerRepository, employerMapper);

        Assertions.assertNotNull(employerDto);
    }
}