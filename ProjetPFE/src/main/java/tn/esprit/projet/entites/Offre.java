package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tn.esprit.projet.entites.Vente;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column 
	private String photo;
	@Column(length = 25)
	private String nomOffre;
	@Column(length = 50)
	private Date dateOffre;
	@Column(length = 100)
	private String adresse;
   
	@Nullable
	@OneToOne
	private Vente vente;
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Nullable
	@OneToOne
	private Location location;
	@Nullable
	@OneToOne
	private Echange echange;
	  @ManyToOne
	    private Admin admin;
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "offre")
	  //  @JsonIgnore
	    private List<Produit> listProd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomOffre() {
		return nomOffre;
	}

	public void setNomOffre(String nomOffre) {
		this.nomOffre = nomOffre;
	}

	public Date getDateOffre() {
		return dateOffre;
	}

	public void setDateOffre(Date dateOffre) {
		this.dateOffre = dateOffre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Echange getEchange() {
		return echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

	public List<Produit> getListProd() {
		return listProd;
	}

	public void setListProd(List<Produit> listProd) {
		this.listProd = listProd;
	}

	 
 
	public Offre(long id, String photo, String nomOffre, Date dateOffre, String adresse, Vente vente, Location location,
			Echange echange, Admin admin, List<Produit> listProd) {
		super();
		this.id = id;
		this.photo = photo;
		this.nomOffre = nomOffre;
		this.dateOffre = dateOffre;
		this.adresse = adresse;
		this.vente = vente;
		this.location = location;
		this.echange = echange;
		this.admin = admin;
		this.listProd = listProd;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", photo=" + photo + ", nomOffre=" + nomOffre + ", dateOffre=" + dateOffre
				+ ", adresse=" + adresse + ", vente=" + vente + ", location=" + location + ", echange=" + echange
				+ ", admin=" + admin + ", listProd=" + listProd + "]";
	}

	public Offre() {
		super();
	}
	  
	  
   
}
