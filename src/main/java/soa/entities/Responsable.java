package soa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Responsable {
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String nom;

	@Column(length = 50)
	private String prenom;

	@OneToOne(mappedBy = "responsable")
	private Stock stock;
	@OneToMany(mappedBy = "responsable" ,cascade = {CascadeType.REMOVE ,CascadeType.MERGE , CascadeType.PERSIST})

	private Collection<Facture> factures = new ArrayList<Facture>();

	public Responsable(Long id,String nom, String prenom) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Responsable() {

	}

	public Responsable(Long id) {
		this.id=id;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Responsable [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}





	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}