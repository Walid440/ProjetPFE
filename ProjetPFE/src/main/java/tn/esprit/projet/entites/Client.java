package tn.esprit.projet.entites;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Client")
 @Data


 @JsonInclude(value= JsonInclude.Include.NON_NULL)
 @JsonIgnoreProperties(ignoreUnknown=true)
 @NoArgsConstructor
 @AllArgsConstructor
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @Column(name = "Nom")
	private String nom;
	 @Column(name = "Prenom")
	private String prenom;
	 @Column(name = "Adresse",length = 100)
	private String adresse;
	 @Column(name = "Email",length = 25)
	private String Email;
	 @Column(name = "Telephone",length = 25)
	private String telephone;
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
 	 private List<Commande> listCommande;
	  
	  
	public Client() {
		super();
	}


	public Client(Long id, String nom, String prenom, String adresse, String email, String telephone,
			List<Commande> listCommande) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		Email = email;
		this.telephone = telephone;
		this.listCommande = listCommande;
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


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public List<Commande> getListCommande() {
		return listCommande;
	}


	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", Email=" + Email
				+ ", telephone=" + telephone + ", listCommande=" + listCommande + "]";
	}
   
}
