package com.mca.service.impl;

import com.mca.service.GameSagaAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class GameSagaAPIServiceImpl implements GameSagaAPIService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${game-sagas.api.url.base}")
    private String gameSagaApiBase;

    @Value("${game-sagas.api.url.related-sagas}")
    private String relatedSagasUrl;

    @Override
    public List<String> getRelatedSagasList(String gameId) {
        log.info("[GameSagaAPIService] Call to endpoint: {}", relatedSagasUrl);
        List<String> relatedSagasList = new ArrayList<>();

        String url = gameSagaApiBase + relatedSagasUrl.replace("{gameId}", gameId);
        ResponseEntity<String[]> response = restTemplate.exchange(url, HttpMethod.GET, null, String[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            String[] relatedSagasArray = response.getBody();
            if (relatedSagasArray != null && relatedSagasArray.length > 0) {
                relatedSagasList = Arrays.asList(relatedSagasArray);
            }
        } else {
            log.error("[GameSagaAPIService] Error when calling {} endpoint. HttpStatus: {}", relatedSagasUrl, response.getStatusCode());
        }

        return relatedSagasList;
    }
}
