package com.cognizant.stock.query.system.repository;

import com.cognizant.stock.query.system.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate
    );
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            BigDecimal price
    );
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}