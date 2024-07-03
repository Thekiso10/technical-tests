package com.mca.service.impl;

import com.mca.infrastructure.model.Stock;
import com.mca.infrastructure.model.VideoGameEvent;
import com.mca.repository.StockRepository;
import com.mca.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public void updateStockFromVideoGameEvent(VideoGameEvent videoGameEvent) {
        Optional<Stock> stockOptional = stockRepository.findById(videoGameEvent.getStock_id());
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setAvailability(videoGameEvent.isAvailability());
            stock.setLastUpdated(videoGameEvent.getTime_update());
            stockRepository.save(stock);
        } else {
            log.warn("No Stock found with ID: {}", videoGameEvent.getStock_id());
        }
    }
}
