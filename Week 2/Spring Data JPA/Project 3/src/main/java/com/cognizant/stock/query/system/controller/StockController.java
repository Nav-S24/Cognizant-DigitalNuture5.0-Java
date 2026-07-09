package com.cognizant.stock.query.system.controller;

import com.cognizant.stock.query.system.model.Stock;
import com.cognizant.stock.query.system.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/facebook")
    public List<Stock> getFacebookStocksBetweenDates(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate endDate) {

        return stockService.getFacebookStocksBetweenDates(
                startDate,
                endDate
        );
    }
    @GetMapping("/google/above")
    public List<Stock> getGoogleStocksAbovePrice(
            @RequestParam BigDecimal price) {

        return stockService.getGoogleStocksAbovePrice(price);
    }
    @GetMapping("/top-volume")
    public List<Stock> getTop3StocksByVolume() {
        return stockService.getTop3StocksByVolume();
    }
    @GetMapping("/netflix/lowest")
    public List<Stock> getThreeLowestNetflixStocks() {
        return stockService.getThreeLowestNetflixStocks();
    }
}