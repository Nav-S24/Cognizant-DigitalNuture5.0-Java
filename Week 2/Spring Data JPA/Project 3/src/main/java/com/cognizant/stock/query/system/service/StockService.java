package com.cognizant.stock.query.system.service;

import com.cognizant.stock.query.system.model.Stock;
import com.cognizant.stock.query.system.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<Stock> getFacebookStocksBetweenDates(
            LocalDate startDate,
            LocalDate endDate) {

        return stockRepository.findByCodeAndDateBetween(
                "FB",
                startDate,
                endDate
        );
    }
    @Transactional(readOnly = true)
    public List<Stock> getGoogleStocksAbovePrice(BigDecimal price) {

        return stockRepository.findByCodeAndCloseGreaterThan(
                "GOOGL",
                price
        );
    }
    @Transactional(readOnly = true)
    public List<Stock> getTop3StocksByVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }
    @Transactional(readOnly = true)
    public List<Stock> getThreeLowestNetflixStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}