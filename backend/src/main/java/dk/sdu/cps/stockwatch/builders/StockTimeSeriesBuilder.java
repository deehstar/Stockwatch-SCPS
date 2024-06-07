package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import dk.sdu.cps.stockwatch.service.StockService;

import java.sql.Timestamp;

public class StockTimeSeriesBuilder implements Builder{
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Stock stock;
    private Timestamp timestamp;
    private StockService stockService;

    public StockTimeSeriesBuilder() {
        this.open = null;
        this.high = null;
        this.low = null;
        this.close = null;
        this.volume = null;
        Stock stock = new Stock();
        stock.setSymbol("AAPL");
        stock.setName("Apple Inc.");
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public StockTimeSeriesBuilder setOpen(Double open) {
        this.open = open;
        return this;
    }

    public StockTimeSeriesBuilder setHigh(Double high) {
        this.high = high;
        return this;
    }

    public StockTimeSeriesBuilder setLow(Double low) {
        this.low = low;
        return this;
    }

    public StockTimeSeriesBuilder setClose(Double close) {
        this.close = close;
        return this;
    }

    public StockTimeSeriesBuilder setVolume(Double volume) {
        this.volume = volume;
        return this;
    }

    public StockTimeSeriesBuilder setStock(Stock stock) {
        this.stock = stock;
        return this;
    }

    public StockTimeSeriesBuilder setTimeStamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public StockTimeSeries build() {
        StockTimeSeries stockTimeSeries = new StockTimeSeries();
        stockTimeSeries.setOpen(open);
        stockTimeSeries.setHigh(high);
        stockTimeSeries.setLow(low);
        stockTimeSeries.setClose(close);
        stockTimeSeries.setVolume(volume);
        stockTimeSeries.setStock(stock);
        stockTimeSeries.setTimeStamp(timestamp);
        return stockTimeSeries;
    }
}
