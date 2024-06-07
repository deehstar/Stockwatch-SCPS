package dk.sdu.cps.stockwatch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class StockTimeSeries {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("1. open")
    private Double open;
    @JsonProperty("2. high")
    private Double high;
    @JsonProperty("3. low")
    private Double low;
    @JsonProperty("4. close")
    private Double close;
    @JsonProperty("5. volume")
    private Double volume;
    @ManyToOne
    @JsonIgnore
    private Stock stock;
    private Timestamp timeStamp;
}
