package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import tn.esprit.projet.entites.LivraisonProd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {
	
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String username;
	@Column(length = 1000)
	private String password;
	private String role;
	private String mail;
	 
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<LivraisonProd> LivProd;
    
  @ManyToMany(mappedBy="com",fetch=FetchType.LAZY)
    //@JsonIgnore
    private List<Paiement> paie;
    
  
    
}
