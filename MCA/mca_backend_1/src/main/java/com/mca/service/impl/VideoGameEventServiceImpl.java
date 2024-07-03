package com.mca.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mca.infrastructure.model.VideoGameEvent;
import com.mca.service.StockService;
import com.mca.service.VideoGameEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoGameEventServiceImpl implements VideoGameEventService {

    private final StockService stockService;

    private final Gson gson;

    @Override
    public void updateStockFromKafka(String videoGameEventMessageKafka) {
        VideoGameEvent videoGameEvent = convertStock(videoGameEventMessageKafka);
        if (videoGameEvent != null) {
            stockService.updateStockFromVideoGameEvent(videoGameEvent);
        }
    }

    private VideoGameEvent convertStock(String videoGameEventMessage) {
        VideoGameEvent videoGameEvent = null;
        try {
            videoGameEvent = gson.fromJson(videoGameEventMessage, VideoGameEvent.class);
        } catch (JsonSyntaxException e) {
            log.error("Error al convertir el JSON a objeto VideoGameEvent", e);
        }

        return videoGameEvent;
    }
}
