package com.recomotor.backend.service.Interface;

import com.recomotor.backend.entity.Model;
import com.recomotor.backend.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }
}
