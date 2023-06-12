package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tn.esprit.projet.entites.Vente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(length = 25)
	private String nomOffre;
	@Column(length = 50)
	private Date dateOffre;
	@Column(length = 100)
	private String adresse;
   
	@OneToOne
	private Vente vente;
	@OneToOne
	private Location location;
	@OneToOne
	private Echange echange;
	
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "offre")
	  //  @JsonIgnore
	    private List<Produit> listProd;
	  
	  
   
}
