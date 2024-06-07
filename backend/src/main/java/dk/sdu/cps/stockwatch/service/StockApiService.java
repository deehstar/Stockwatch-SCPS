package dk.sdu.cps.stockwatch.service;

import dk.sdu.cps.stockwatch.model.Stock;
import dk.sdu.cps.stockwatch.model.StockResponse;
import dk.sdu.cps.stockwatch.model.StockTimeSeries;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

@Service
public class StockApiService {

    @Value("${API_KEY}")
    private String apiKey;
    @Value("${API_URL}")
    private String apiUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private StockTimeSeriesService stockTimeSeriesService;
    private StockService stockService;
    private ArrayList<String> stockSymbols;

    public StockApiService(StockTimeSeriesService stockTimeSeriesService, StockService stockService, ArrayList<String> stockSymbols) {
        this.stockTimeSeriesService = stockTimeSeriesService;
        this.stockService = stockService;
        this.stockSymbols = stockSymbols;
    }


    @PostConstruct
    public void getStockData() {
        for (Stock stock : stockService.getStocks()) {
            String url = UriComponentsBuilder.fromHttpUrl(this.apiUrl)
                    .path("/query")
                    .queryParam("function", "TIME_SERIES_INTRADAY")
                    .queryParam("symbol", stock.getSymbol())
                    .queryParam("interval", "5min")
                    .queryParam("apikey", apiKey)
                    .toUriString();
            StockResponse response = restTemplate.getForObject(url, StockResponse.class);
            System.out.println(response);
            assert response != null;
            for(Map.Entry<Timestamp, StockTimeSeries> entry : response.getTimeSeries().entrySet()) {
                StockTimeSeries stockTimeSeries = entry.getValue();
                stockTimeSeriesService.create(
                        stockTimeSeries.getOpen(),
                        stockTimeSeries.getHigh(),
                        stockTimeSeries.getLow(),
                        stockTimeSeries.getClose(),
                        stockTimeSeries.getVolume(),
                        entry.getKey(),
                        stock);
            }
        }
    }

}
