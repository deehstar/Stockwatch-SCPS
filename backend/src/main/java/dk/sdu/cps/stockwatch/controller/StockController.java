package dk.sdu.cps.stockwatch.controller;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.service.StockService;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/stock")
@CrossOrigin
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getStocks() {
        return ResponseEntity.ok(stockService.getStocks());
    }

    @GetMapping("{stockId}")
    public ResponseEntity<Stock> getStock(@PathVariable Long stockId) {
        Optional<Stock> optionalStock = stockService.getStock(stockId);
        if (optionalStock.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalStock.get());
    }

    @GetMapping("{stockId}/timeseries")
    public ResponseEntity<List<StockTimeSeries>>  getStockTimeSeries(@PathVariable Long stockId) {
        Optional<Stock> optionalStock = stockService.getStock(stockId);
        if (optionalStock.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        if (optionalStock.isPresent()) {
            return ResponseEntity.ok(optionalStock.get().getStockTimeSeries());
        }
        return ResponseEntity.badRequest().build();
    }

}
