package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soa.entities.Responsable;


public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
    @Query("SELECT c FROM Responsable c WHERE c.id = :id")
    Responsable getresponsableById(@Param("id") Long id);
    @Query("SELECT c FROM Responsable c WHERE c.nom = :nom")

    Responsable findByNom(@Param("nom")String nom);
}
