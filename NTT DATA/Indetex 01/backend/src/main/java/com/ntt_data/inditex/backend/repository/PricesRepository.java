package com.ntt_data.inditex.backend.repository;

import com.ntt_data.inditex.backend.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Long> {

    @Query("SELECT p " +
            "FROM PricesEntity p " +
            "WHERE p.product.id = :productId AND p.brand.id = :brandId AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    Optional<PricesEntity> findTopByProductAndBrandAndDate(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("date") Instant date);
}
