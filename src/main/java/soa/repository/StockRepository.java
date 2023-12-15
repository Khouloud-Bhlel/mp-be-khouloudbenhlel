package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Stock;


public interface StockRepository extends JpaRepository<Stock, Long> { }
