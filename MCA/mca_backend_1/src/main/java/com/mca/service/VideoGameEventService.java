package com.mca.service;


public interface VideoGameEventService {

    void updateStockFromKafka(String stockMessageKafka);
}
