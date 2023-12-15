package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Responsable;
import soa.repository.ResponsableRepository;

import java.util.List;
public class ResponsableMetierImpl  implements ResponsableMetierInterface {
    @Autowired
    ResponsableRepository responsableRep;
    @Override
    public Responsable addclient(Responsable cl) {
        return responsableRep.save(cl);
    }

    @Override
    public List<Responsable> addListclient(List<Responsable> listclient) {
        return responsableRep.saveAll(listclient);
    }



    @Override
    public String deleteclient(Long idClient) {
        String ch="";
        responsableRep.deleteById(idClient);
        ch="client deleteed succefuly !!!";
        return ch;
    }

    @Override
    public List<Responsable> getallclients() {
        return responsableRep.findAll();
    }

    @Override
    public Responsable getresponsableById(Long id) {
        return responsableRep.getresponsableById(id);
    }


    @Override
    public Responsable getresponsablebyname(String nom) {
        return responsableRep.findByNom(nom);
    }



}
