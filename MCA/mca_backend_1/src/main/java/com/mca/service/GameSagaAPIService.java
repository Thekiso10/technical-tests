package com.mca.service;

import java.util.List;

public interface GameSagaAPIService {

    List<String> getRelatedSagasList(String gameId);
}
