package dk.sdu.cps.stockwatch.controller;

import dk.sdu.cps.stockwatch.service.StockApiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stockapi")
@CrossOrigin
public class StockApiController {
    private final StockApiService stockApiService;

    public StockApiController(StockApiService stockApiService) {
        this.stockApiService = stockApiService;
    }

    @PostMapping("/update")
    public void updateStocks() {
        stockApiService.getStockData();
    }
}
