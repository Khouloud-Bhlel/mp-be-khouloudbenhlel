package soa.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
public class FactureDetail {
    @Id
    @GeneratedValue
    private  Long id;
    private  int quantite ;
   // @Column(name = "prixunitaire", columnDefinition = "DECIMAL(10, 2) DEFAULT '0.00'")

    private  double prix ;

    private  double montant ;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Facture facture;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Produit Produit;

    // constructeur

    public FactureDetail(){}

    public FactureDetail(Long id, int quantite, double prix, Facture facture, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
        this.facture = facture;
        Produit = produit;
    }
    public FactureDetail(Long id, int quantite, double prix, double montant,Facture facture, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
        this.montant=montant;
        this.facture = facture;
        Produit = produit;
    }


    // getter et setter

    public Produit getProduit() {
        return Produit;
    }

    public void setProduit(soa.entities.Produit produit) {
        Produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getPrix() {
        // Assuming 'produit' is not null, you can access the 'prix' property from the associated Produit
        return  Produit.getPrix();
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "FactureDetail{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", montant=" + montant +

                ", facture=" + facture +
                ", Produit=" + Produit +
                '}';
    }
}
