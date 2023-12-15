package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import soa.entities.*;
import soa.repository.FactureDetailRepository;
import soa.repository.FactureRepository;

import java.util.List;
@Service
public class FactureDetailMetierImpl implements FactureDetailMetierInterface {
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private FactureDetailRepository factureDetailRepository;


    @Override
    public void ajoutFactureDetail(FactureDetail df) {

        factureDetailRepository.save(df);
    }
    @Override
    public void ajoutFactureDetail(FactureDetail factureDetail, Long idFacture) {
        Facture facture = factureRepository.findById(idFacture).orElse(null);
        if (facture != null) {
            factureRepository.save(facture);
            factureDetail.setFacture(facture);
            factureDetailRepository.save(factureDetail);
        } else {
            // Gérer le cas où la facture n'est pas trouvée
        }
    }

    public FactureDetail getFactureDetailById(Long id) {

        return factureDetailRepository.findById(id).orElse(null);
    }

    public void supprimerFactureDetail(Long id) {
        factureDetailRepository.deleteById(id);
    }

    @Override
    public FactureDetail updateFactureDetail(Long id) {
        FactureDetail factureDetail = factureDetailRepository.findById(id).orElse(null);

            return factureDetailRepository.save(factureDetail);

    }
    @Override
    public double calculeMontant(FactureDetail factureDetail) {
        double prix = factureDetail.getProduit().getPrix(); // Supposons que le prix du produit soit stocké dans l'objet Produit lié à FactureDetail
        int quantite = factureDetail.getQuantite();
        return prix * quantite;
    }


}