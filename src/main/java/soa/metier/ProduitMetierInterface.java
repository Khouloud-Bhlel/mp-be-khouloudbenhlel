package soa.metier;


import soa.entities.Categorie;
import soa.entities.Produit;
import soa.entities.Stock;

import java.util.Date;
import java.util.List;

public interface ProduitMetierInterface {
   boolean changerCategorieProduit(Long idProduit,  Long idNouvelleCategorie );
   void ajouterProduit(Produit p);
   void ajouterProduit(Produit p, Categorie c);
   void ajouterProduit(Produit p, Categorie c, Stock s);
   List<Produit> listeProduits();
   void rendreProduitsEnPromotionAvant(Date date);
   double calculerCoutVenteStock(double coefficientRemise);
}
