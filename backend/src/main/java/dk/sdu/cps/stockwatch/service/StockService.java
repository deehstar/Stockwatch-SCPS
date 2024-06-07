package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.repository.StockRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
public class StockService {
        private Stock stock;
        private final StockRepository stockRepository;

        public StockService(StockRepository stockRepository) {
            this.stockRepository = stockRepository;
            if (stockRepository.findAll().isEmpty()) {
                stock = this.create("AAPL", "Apple Inc.");
                stock = this.create("IBM", "IBM");
            }
        }

        public Stock create(String symbol, String name) {
            Stock stock = new Stock();
            stock.setSymbol(symbol);
            stock.setName(name);
            if (stockRepository.findBySymbol(symbol).isEmpty()) {
                return stockRepository.save(stock);
            }
            return stockRepository.findBySymbol(symbol).get();
        }

    public Optional<Stock> getStock(Long stockId) {
        return stockRepository.findById(stockId);
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }
}
