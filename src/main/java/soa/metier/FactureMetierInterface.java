package soa.metier;

import soa.entities.Devise;
import soa.entities.Facture;
import soa.entities.FactureDetail;
import soa.entities.Produit;

import java.util.List;

public interface FactureMetierInterface {
     Facture ajoutFacture(Facture f);
    List<Facture> getlisteFacture();
     Facture getFactureById(Long id);
   void supprimerFacture(Long id);
   Facture updateFacture(Long id, Facture f);
}
