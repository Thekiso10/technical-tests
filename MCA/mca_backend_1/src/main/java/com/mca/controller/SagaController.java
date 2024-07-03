package com.mca.controller;

import com.mca.infrastructure.dto.VideoGameDTO;
import com.mca.service.SagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class SagaController {

    private final SagaService sagaService;

    @GetMapping("/{gameId}/saga")
    public ResponseEntity<List<VideoGameDTO>> getRelatedSagas(@PathVariable("gameId") String gameId) {
        List<VideoGameDTO> relatedSagas = sagaService.getRelatedSagas(gameId);

        if (relatedSagas != null && !relatedSagas.isEmpty()) {
            return new ResponseEntity<>(relatedSagas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
