package com.mca.service;

import com.mca.infrastructure.model.VideoGameEvent;

public interface StockService {

    void updateStockFromVideoGameEvent(VideoGameEvent videoGameEvent);
}
