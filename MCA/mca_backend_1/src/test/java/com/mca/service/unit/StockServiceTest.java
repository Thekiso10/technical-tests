package com.mca.service.unit;

import com.mca.infrastructure.model.VideoGame;
import com.mca.infrastructure.model.VideoGameEvent;
import com.mca.infrastructure.model.Stock;
import com.mca.repository.StockRepository;
import com.mca.service.impl.StockServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test
    void testUpdateStockFromVideoGameEvent_StockExists() {
        long stockId = 123L;
        boolean availability = true;
        Timestamp timeUpdate = new Timestamp(System.currentTimeMillis());
        VideoGameEvent videoGameEvent = buildVideoGameEvent(stockId, availability, timeUpdate);

        Stock existingStock = new Stock(stockId, availability, timeUpdate, new VideoGame());
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(existingStock));

        stockService.updateStockFromVideoGameEvent(videoGameEvent);

        verify(stockRepository).findById(stockId);
        verify(stockRepository).save(existingStock);
    }

    @Test
    void testUpdateStockFromVideoGameEvent_StockNotExists() {
        long stockId = 456L;
        boolean availability = true;
        Timestamp timeUpdate = new Timestamp(System.currentTimeMillis());
        VideoGameEvent videoGameEvent = buildVideoGameEvent(stockId, availability, timeUpdate);

        when(stockRepository.findById(stockId)).thenReturn(Optional.empty());

        stockService.updateStockFromVideoGameEvent(videoGameEvent);

        verify(stockRepository).findById(stockId);
        verify(stockRepository, never()).save(any());
    }

    private VideoGameEvent buildVideoGameEvent(Long stockId, boolean availability, Timestamp timeUpdate) {
        return VideoGameEvent.builder().stock_id(stockId)
                .availability(availability)
                .time_update(timeUpdate)
                .build();
    }
}