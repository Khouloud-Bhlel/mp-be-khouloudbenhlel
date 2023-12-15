package soa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue
    private Long id;
    private  int numero;


    private String dateFact;


    //detaillfacture
    @JsonIgnore
    @OneToMany (mappedBy = "facture" ,cascade = {CascadeType.REMOVE  , CascadeType.MERGE , CascadeType.PERSIST})
    private Collection<FactureDetail> detailsfacture = new ArrayList<FactureDetail>();
    //reglement facture
    @OneToMany (mappedBy = "facture" ,cascade = {CascadeType.REMOVE  , CascadeType.MERGE , CascadeType.PERSIST})
    private Collection<ReglementFacture> reglementFacture = new ArrayList<ReglementFacture>();
   //responsable
   // @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Responsable responsable;

   @ManyToOne(cascade = {CascadeType.MERGE})
    private Devise devise;
    //constructeur
    public Facture() {

    }
    public Facture(Long id) {
        this.id=id;
    }
    public Facture(Long id, int numero, String dateFact,  Responsable responsable, Devise devise) {
        this.id = id;
        this.numero = numero;
        this.dateFact = dateFact;
        this.responsable = responsable;
        this.devise = devise;
    }

    public void setReglementFacture(Collection<ReglementFacture> reglementFacture) {
        this.reglementFacture = reglementFacture;
    }

    // getter et setter


    public Collection<FactureDetail> getDetailsfacture() {
        return detailsfacture;
    }

    public void setDetailsfacture(Collection<FactureDetail> detailsfacture) {
        this.detailsfacture = detailsfacture;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateFact() {
        return dateFact;
    }

    public void setDateFact(String dateFact) {
        this.dateFact = dateFact;
    }

    public Long getId() {
        return id;
    }


    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", numero=" + numero +
                ", dateFact=" + dateFact +
                ", responsable=" + responsable +
                ", devise=" + devise +
                '}';
    }
}
