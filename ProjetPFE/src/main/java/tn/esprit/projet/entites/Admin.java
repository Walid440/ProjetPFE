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
@Table(name = "Admin")
 @Data
public class Admin implements Serializable {

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
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
 	 private List<Offre> listOffre;
	  
	  
	public Admin() {
		super();
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


	public List<Offre> getListOffre() {
		return listOffre;
	}


	public void setListOffre(List<Offre> listOffre) {
		this.listOffre = listOffre;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", Email=" + Email
				+ ", telephone=" + telephone + ", listOffre=" + listOffre + "]";
	}


	public Admin(Long id, String nom, String prenom, String adresse, String email, String telephone,
			List<Offre> listOffre) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		Email = email;
		this.telephone = telephone;
		this.listOffre = listOffre;
	}


	 
   
}
