package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Categorie;


public interface CategorieRepository extends JpaRepository<Categorie, Long> { }
