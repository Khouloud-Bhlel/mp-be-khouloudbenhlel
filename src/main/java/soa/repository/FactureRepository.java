package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
