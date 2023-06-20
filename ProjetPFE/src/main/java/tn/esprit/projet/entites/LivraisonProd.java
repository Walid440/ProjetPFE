package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import tn.esprit.projet.entites.Commande;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonProd implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String adresse;
	@Column(length = 50)
	private String prenom;
	@Column(length = 100)
	private Date date;
 
    @ManyToMany(mappedBy="LivProd",fetch=FetchType.LAZY)
    //@JsonIgnore
    private List<Commande> ListCom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Commande> getListCom() {
		return ListCom;
	}

	public void setListCom(List<Commande> listCom) {
		ListCom = listCom;
	}

	public LivraisonProd(long id, String adresse, String prenom, Date date, List<Commande> listCom) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.prenom = prenom;
		this.date = date;
		ListCom = listCom;
	}

	public LivraisonProd() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
