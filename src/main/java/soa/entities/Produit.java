package soa.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Produit {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 50)
	private String designation;

	private double prix;
	private int quantite;

	@Temporal(TemporalType.DATE)
	private Date dateAchat;

	private boolean enPromotion;

	@ManyToOne (cascade = {CascadeType.MERGE})
	private Categorie categorie;
	
	@ManyToMany (cascade = {CascadeType.PERSIST})
	private Collection<Stock> stocks = new ArrayList<Stock>();
	@OneToMany(mappedBy = "Produit" ,cascade = {CascadeType.REMOVE  , CascadeType.MERGE , CascadeType.PERSIST})

	private Collection<FactureDetail> detailsfacture = new ArrayList<FactureDetail>();


	public Collection<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Collection<Stock> stocks) {
		this.stocks = stocks;
	}

	public Produit(long id,String designation, double prix, int quantite, Date dateAchat, Categorie categorie) {
		super();
		this.id=id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
		this.categorie = categorie;
	}
	public Produit(long id) {
		this.id=id;

	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public Produit(String designation, double prix, int quantite, Date dateAchat) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.dateAchat = dateAchat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnPromotion() {
		return enPromotion;
	}

	public void setEnPromotion(boolean enPromotion) {
		this.enPromotion = enPromotion;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit() {
		super();

	}

	public Produit(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

	@Override
	public String toString() {
	  return  "  Produit [id=" + id + ", designation=" + designation + 
               ",   prix=" + prix + ", quantite=" + quantite+ ", enPromotion=" + enPromotion+
			  ", dateAchat=" + dateAchat + ", categorie=" + categorie + ", stocks=" + stocks + "]";
	}

	public Produit(Long id, String designation, double prix, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
}
