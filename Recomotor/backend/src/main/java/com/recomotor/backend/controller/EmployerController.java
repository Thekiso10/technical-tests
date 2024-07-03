package com.recomotor.backend.controller;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.mapper.EmployerMapper;
import com.recomotor.backend.service.Interface.EmployerService;
import com.recomotor.backend.service.Interface.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/employers/")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @Autowired
    ModelService modelService;

    @Autowired
    EmployerMapper employerMapper;

    @GetMapping("{numEmployer}")
    public ResponseEntity<EmployerDto> getEmployer(@PathVariable Integer numEmployer) {
        log.info("Get Employer from numEmployer: {}", numEmployer);
        Optional<Employer> employer = employerService.getEmployerByNumEmployer(numEmployer);
        return employer.map(value -> ResponseEntity.ok(employerMapper.mapToEmployerDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("update/favour-model/{id}")
    public ResponseEntity<EmployerDto> updateFavourModel(@PathVariable Long id, @RequestParam Long idModel) {
        log.info("Update favour model with id: {} to Employer id: {}", idModel, id);
        EmployerDto employerDto = employerService.updateFavourModel(employerService.getEmployerById(id), modelService.getModelById(idModel));
        return (employerDto != null) ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
