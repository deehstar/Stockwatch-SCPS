package dk.sdu.cps.stockwatch.builders;

import dk.sdu.cps.stockwatch.model.Stock;

import java.sql.Timestamp;

public interface Builder {
    StockTimeSeriesBuilder setOpen(Double open);
    StockTimeSeriesBuilder setHigh(Double high);
    StockTimeSeriesBuilder setLow(Double low);
    StockTimeSeriesBuilder setClose(Double close);
    StockTimeSeriesBuilder setVolume(Double volume);
    StockTimeSeriesBuilder setStock(Stock stock);
    StockTimeSeriesBuilder setTimeStamp(Timestamp timestamp);
}
