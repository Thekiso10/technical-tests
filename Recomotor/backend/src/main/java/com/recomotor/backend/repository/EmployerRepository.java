package com.recomotor.backend.repository;

import com.recomotor.backend.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Optional<Employer> findByNumEmployer(Integer numEmployer);
}
