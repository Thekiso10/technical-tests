package com.mca.service;

import com.mca.infrastructure.dto.VideoGameDTO;

import java.util.List;

public interface SagaService {

    List<VideoGameDTO> getRelatedSagas(String gameId);
}
