package com.recomotor.backend.service.Interface;

import com.recomotor.backend.entity.Model;

import java.util.Optional;

public interface ModelService {

    Optional<Model> getModelById(Long id);
}
