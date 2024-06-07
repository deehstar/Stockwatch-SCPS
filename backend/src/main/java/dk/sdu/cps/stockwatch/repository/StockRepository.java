package dk.sdu.cps.stockwatch.repository;

import dk.sdu.cps.stockwatch.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long>{
    Optional<Stock> findBySymbol(String symbol);
}
