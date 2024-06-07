package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.builders.StockTimeSeriesBuilder;
import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.repository.StockTimeSeriesRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StockTimeSeriesService {

    private final StockTimeSeriesRepository stockTimeSeriesRepository;
    private final StockService stockService;

    public StockTimeSeriesService(StockTimeSeriesRepository stockTimeSeriesRepository,
                                  StockService stockService) {
        this.stockTimeSeriesRepository = stockTimeSeriesRepository;
        this.stockService = stockService;


    }

    public StockTimeSeries create(Double open, Double high, Double low, Double close, Double volume, Timestamp timestamp, Stock stock) {
        if (stockTimeSeriesRepository.findByStockIdAndTimeStamp(stock.getId(), timestamp).isEmpty()) {
            return stockTimeSeriesRepository.save(new StockTimeSeriesBuilder()
                    .setOpen(open)
                    .setHigh(high)
                    .setLow(low)
                    .setClose(close)
                    .setVolume(volume)
                    .setStock(stock)
                    .setTimeStamp(timestamp)
                    .build());
        }
        else {
            return stockTimeSeriesRepository.findByStockIdAndTimeStamp(stock.getId(), timestamp).get();
        }
    }
}
