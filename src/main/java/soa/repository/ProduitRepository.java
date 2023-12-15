package soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import soa.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select p from Produit p where p.designation like %:x% ")
	public List<Produit> findByDesignation(@Param("x") String mc);

	@Query("select p from Produit p where p.designation like %:x% and p.prix > :y")
	public List<Produit> findByDesignationAndPrix(@Param("x") String mc, @Param("y") double prix);

	@Query("update Produit p set p.designation =:designation where p.id = :id")
	@Modifying
	@Transactional
	public int mettreAJourDesignation(@Param("designation") String designation, @Param("id") Long idProduit);
	List<Produit> findByPrixGreaterThan(double prixMin);
	   // Retourner la liste des Produits par recherche par designation et dont le prix est supérieur à un prix minimal
    List<Produit> findByDesignationLikeAndPrixGreaterThan(String mc, double prixMin);
	
	//Retourner la liste de tous les produits en ordre croissant selon le prix
    List<Produit> findAllByOrderByPrixAsc();
    
  //Retourner la liste de tous les produits en ordre croissant selon le prix et prix > prix_min
   List<Produit> findByPrixGreaterThanOrderByPrixAsc(double prixMin);
         
    //Retourner la liste des produits dont la date d’achat est supérieure à une date donnée
    List <Produit> findAllByDateAchatAfter(java.util.Date dateX);
	//Retourner la liste des produits dont la date d’achat est inférieure à une date donnée
	List <Produit> findAllByDateAchatBefore(java.util.Date dateX);
}
