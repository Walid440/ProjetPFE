package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String nomProd;
	@Column(length = 50)
	private String marque;
	@Column(length = 50)
	private String modele;
	@Column(length = 100)
	private String prix;
 
	@Column(length = 100)
	private int annee;
	
	
	  @ManyToMany
//	    @JsonIgnore
	    private List<Commande> listCommand;
	  @ManyToOne
	    private Offre offre;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	 
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public List<Commande> getListCommand() {
		return listCommand;
	}
	public void setListCommand(List<Commande> listCommand) {
		this.listCommand = listCommand;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProd=" + nomProd + ", marque=" + marque + ", modele=" + modele + ", prix="
				+ prix + ", annee=" + annee + ", listCommand=" + listCommand + ", offre=" + offre + "]";
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
