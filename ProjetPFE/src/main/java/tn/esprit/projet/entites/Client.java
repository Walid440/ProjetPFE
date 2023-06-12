package tn.esprit.projet.entites;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String nom;
	@Column(length = 50)
	private String prenom;
	@Column(length = 100)
	private String adresse;
	@Column(length = 100)
	private String Email;
	@Column(length = 9)
	private String telephone;
	 /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "com")
	   @JsonIgnore
	 // private List<Commande> listCommande;
   */
}