package dk.sdu.cps.stockwatch.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    private String name, symbol;
    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    private List<StockTimeSeries> stockTimeSeries;
}
