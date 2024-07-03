package com.recomotor.backend.service.Interface;

import com.recomotor.backend.dto.EmployerDto;
import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.entity.Model;

import java.util.Optional;

public interface EmployerService {

    Optional<Employer> getEmployerById(Long id);

    Optional<Employer> getEmployerByNumEmployer(Integer numEmployer);

    EmployerDto updateFavourModel(Optional<Employer> employer, Optional<Model> model);

    void saveEmployer(Employer employer);
}
