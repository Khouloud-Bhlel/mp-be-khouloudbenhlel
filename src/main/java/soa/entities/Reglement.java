package soa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reglement {
    @Id
    @GeneratedValue
    private Long id;
    private  double montant;
    @Temporal(TemporalType.DATE)
    private Date dateReg;
    private double detteclt;
    private  double chiffreGlobal;
    @OneToMany (mappedBy = "reglement", cascade = CascadeType.REMOVE)
    private Collection<ReglementFacture> reglementfactures = new ArrayList<ReglementFacture>();

    public Reglement() {

    }

    public Reglement(Long id, double montant, Date dateReg, double detteclt, double chiffreGlobal) {
        this.id = id;
        this.montant = montant;
        this.dateReg = dateReg;
        this.detteclt = detteclt;
        this.chiffreGlobal = chiffreGlobal;
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

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public double getDetteclt() {
        return detteclt;
    }

    public void setDetteclt(double detteclt) {
        this.detteclt = detteclt;
    }

    public double getChiffreGlobal() {
        return chiffreGlobal;
    }

    public void setChiffreGlobal(double chiffreGlobal) {
        this.chiffreGlobal = chiffreGlobal;
    }
    @JsonIgnore

    public Collection<ReglementFacture> getReglementfactures() {
        return reglementfactures;
    }

    public void setReglementfactures(Collection<ReglementFacture> reglementfactures) {
        this.reglementfactures = reglementfactures;
    }

    @Override
    public String toString() {
        return "Reglement{" +
                "id=" + id +
                ", montant=" + montant +
                ", dateReg=" + dateReg +
                ", detteclt=" + detteclt +
                ", chiffreGlobal=" + chiffreGlobal +
                '}';
    }
}
