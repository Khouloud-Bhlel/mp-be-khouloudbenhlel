package soa.metier;

import soa.entities.Responsable;

import java.util.List;

public interface ResponsableMetierInterface {
    public Responsable addclient(Responsable cl);

    public List<Responsable> addListclient(List<Responsable> listclient);
    public String deleteclient(Long idClient);
    public List<Responsable> getallclients();
    public Responsable getresponsableById(Long id);
    public Responsable getresponsablebyname(String nom);



    }
