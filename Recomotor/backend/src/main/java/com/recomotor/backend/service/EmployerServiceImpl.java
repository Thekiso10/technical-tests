package com.recomotor.backend.service;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.entity.Model;
import com.recomotor.backend.mapper.EmployerMapper;
import com.recomotor.backend.repository.EmployerRepository;
import com.recomotor.backend.service.Interface.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerMapper employerMapper;

    @Autowired
    EmployerRepository employerRepository;

    @Override
    public Optional<Employer> getEmployerById(Long id) {
        return employerRepository.findById(id);
    }

    @Override
    public Optional<Employer> getEmployerByNumEmployer(Integer numEmployer) {
        return employerRepository.findByNumEmployer(numEmployer);
    }

    @Override
    public EmployerDto updateFavourModel(Optional<Employer> employer, Optional<Model> model) {
        EmployerDto employerDto = null;

        if (employer.isPresent() && model.isPresent()) {
            employer.get().setFavourModel(model.get());
            saveEmployer(employer.get());

            employerDto = employerMapper.mapToEmployerDto(employer.get());
        }

        return employerDto;
    }

    @Override
    public void saveEmployer(Employer employer) {
        employerRepository.save(employer);
    }
}
