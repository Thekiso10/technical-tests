package com.mca.repository;

import com.mca.infrastructure.dto.VideoGameDTO;
import com.mca.infrastructure.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    @Query("SELECT NEW com.mca.infrastructure.dto.VideoGameDTO(v.id, v.title, p.price, s.availability) " +
            "FROM VideoGame v " +
            "LEFT JOIN v.promotions p " +
            "LEFT JOIN v.stock s " +
            "WHERE v.id IN :gameIdList " +
            "AND s.lastUpdated = (SELECT s2.lastUpdated FROM Stock s2 WHERE s2.videoGame = v) " +
            "AND p.validFrom = (SELECT MAX(p2.validFrom) FROM Promotion p2 WHERE p2.videoGame = v AND p2.validFrom < :dateToday)")
    List<VideoGameDTO> getVideoGameDtoByVideoGameIdList(@Param("gameIdList") List<Long> gameIdList, @Param("dateToday") Timestamp dateToday);
}
