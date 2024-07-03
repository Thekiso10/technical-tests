package com.recomotor.backend.controller;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.service.EmployerServiceImpl;
import com.recomotor.backend.service.Interface.ModelServiceImpl;
import com.recomotor.backend.mapper.EmployerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployerControllerTest {

    @Mock
    private EmployerServiceImpl employerService;

    @Mock
    private ModelServiceImpl modelService;

    @Mock
    private EmployerMapper employerMapper;

    @InjectMocks
    private EmployerController employerController;

    @Test
    void testGetEmployer() {
        Integer numEmployer = 1;
        EmployerDto employerDto = new EmployerDto();
        Optional<Employer> employerOptional = Optional.of(new Employer());

        when(employerService.getEmployerByNumEmployer(numEmployer)).thenReturn(employerOptional);
        when(employerMapper.mapToEmployerDto(employerOptional.get())).thenReturn(employerDto);

        ResponseEntity<EmployerDto> responseEntity = employerController.getEmployer(numEmployer);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employerDto, responseEntity.getBody());
    }

    @Test
    void testUpdateFavourModel() {
        Long id = 1L;
        Long idModel = 2L;
        EmployerDto employerDto = new EmployerDto();
        Optional<Employer> employerOptional = Optional.of(new Employer());

        when(employerService.getEmployerById(id)).thenReturn(employerOptional);
        when(modelService.getModelById(idModel)).thenReturn(Optional.ofNullable(null)); // Cambia esto si necesitas un objeto Model válido
        when(employerService.updateFavourModel(employerOptional, Optional.empty())).thenReturn(employerDto);

        ResponseEntity<EmployerDto> responseEntity = employerController.updateFavourModel(id, idModel);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
