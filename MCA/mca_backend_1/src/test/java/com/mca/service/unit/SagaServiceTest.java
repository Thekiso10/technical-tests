package com.mca.service.unit;

import com.mca.infrastructure.dto.VideoGameDTO;
import com.mca.repository.VideoGameRepository;
import com.mca.service.GameSagaAPIService;
import com.mca.service.impl.SagaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SagaServiceTest {

    @InjectMocks
    private SagaServiceImpl sagaService;

    @Mock
    private GameSagaAPIService gameSagaAPIService;

    @Mock
    private VideoGameRepository videoGameRepository;

    @Test
    void testGetRelatedSagas() {
        // Configurar manualmente el valor de dateTodayString
        ReflectionTestUtils.setField(sagaService, "dateTodayString", "2023-11-24T12:40:01.773Z");

        String gameId = "123";
        List<String> relatedSagasList = Arrays.asList("1", "2");
        List<Long> videoGameIdList = Arrays.asList(1L, 2L);

        when(gameSagaAPIService.getRelatedSagasList(gameId)).thenReturn(relatedSagasList);

        VideoGameDTO game1 = new VideoGameDTO(1L, "Aether Chronicles: Rise of the Phoenix", BigDecimal.valueOf(19.99), true);
        VideoGameDTO game2 = new VideoGameDTO(2L, "Nebulas Descent: Awakening", BigDecimal.valueOf(29.99), false);
        when(videoGameRepository.getVideoGameDtoByVideoGameIdList(eq(videoGameIdList), any(Timestamp.class)))
                .thenReturn(Arrays.asList(game1, game2));

        List<VideoGameDTO> result = sagaService.getRelatedSagas(gameId);

        verify(gameSagaAPIService).getRelatedSagasList(gameId);
        verify(videoGameRepository).getVideoGameDtoByVideoGameIdList(eq(videoGameIdList), any(Timestamp.class));

        assertEquals("Aether Chronicles: Rise of the Phoenix", result.get(0).getTitle());
        assertEquals("Nebulas Descent: Awakening", result.get(1).getTitle());
    }
}
