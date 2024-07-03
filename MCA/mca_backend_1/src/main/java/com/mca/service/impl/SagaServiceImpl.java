package com.mca.service.impl;

import com.mca.infrastructure.dto.VideoGameDTO;
import com.mca.repository.VideoGameRepository;
import com.mca.service.GameSagaAPIService;
import com.mca.service.SagaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SagaServiceImpl implements SagaService {

    private final GameSagaAPIService gameSagaAPIService;

    private final VideoGameRepository videoGameRepository;

    @Value("${date:2023-11-24T12:40:01.773Z}")
    private String dateTodayString;

    @Override
    public List<VideoGameDTO> getRelatedSagas(String gameId) {
        List<Long> relatedSagasList = gameSagaAPIService.getRelatedSagasList(gameId).stream().map(Long::parseLong).toList();

        return videoGameRepository.getVideoGameDtoByVideoGameIdList(relatedSagasList, getDateToday()).stream()
                .sorted(Comparator.comparingLong(videoGameDTO -> relatedSagasList.indexOf(Long.parseLong(videoGameDTO.getId()))))
                .collect(Collectors.toList());
    }

    private Timestamp getDateToday() {
        return Timestamp.valueOf(LocalDateTime.parse(dateTodayString, DateTimeFormatter.ISO_DATE_TIME));
    }
}
