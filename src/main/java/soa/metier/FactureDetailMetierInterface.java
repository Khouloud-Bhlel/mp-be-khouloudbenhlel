package soa.metier;

import soa.entities.Facture;
import soa.entities.FactureDetail;

import java.util.List;

public interface FactureDetailMetierInterface {
    void ajoutFactureDetail(FactureDetail df);
    void ajoutFactureDetail(FactureDetail df, Long idFacture );
   FactureDetail getFactureDetailById(Long id);
   FactureDetail updateFactureDetail(Long id);
   void supprimerFactureDetail(Long id);
     double calculeMontant(FactureDetail factureDetail);

}
