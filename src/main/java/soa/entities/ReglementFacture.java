package soa.entities;

import jakarta.persistence.*;

@Entity
public class ReglementFacture {
    @Id
    @GeneratedValue
    private Long id;

    private double montant;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Facture facture;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Reglement reglement;
    public ReglementFacture( ) {

    }
    public ReglementFacture(Long id) {
        this.id = id;
    }

    public ReglementFacture(Long id, double montant, Facture facture, Reglement reglement) {
        this.id = id;
        this.montant = montant;
        this.facture = facture;
        this.reglement = reglement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    @Override
    public String toString() {
        return "ReglementFacture{" +
                "id=" + id +
                ", montant=" + montant +
                ", facture=" + facture +
                ", reglement=" + reglement +
                '}';
    }
}
