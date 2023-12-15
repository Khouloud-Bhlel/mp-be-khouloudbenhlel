package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import soa.entities.Devise;
import soa.entities.Facture;
import soa.entities.FactureDetail;
import soa.repository.FactureRepository;

import java.util.List;
@Service
public class FactureMetierImpl implements FactureMetierInterface {
    @Autowired
    private FactureRepository factureRepository;




    @Override
    public Facture ajoutFacture(Facture f) {
       return factureRepository.save(f);
    }

    @Override

    public List<Facture> getlisteFacture() {

        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    public void supprimerFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public Facture updateFacture(Long id, Facture f) {
        Facture facture = factureRepository.findById(id).orElse(null);
          if(f != null){
              f.setNumero(f.getNumero());
              return factureRepository.save(f);
          }else{

            return null;
    }
}}
