package com.recomotor.backend.repository;

import com.recomotor.backend.entity.Employer;
import com.recomotor.backend.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
