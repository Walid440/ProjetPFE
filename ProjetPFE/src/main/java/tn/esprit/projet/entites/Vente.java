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
public class Vente implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEchange;
	
	private long VoitureA;
 
	@Column(length = 25)
	private Date DateVente;
 
	 @Column(length = 50)
	private String ClientAcheteur;
    @Column(length = 50)
	private String AgentDeVente;
    @Column(length = 50)
   	private String StatutVente;
    @Column(length = 50)
   	private String prix;
    
    @ManyToOne
    private Client client;
    
    private StatusVoiture statusVoi;
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "Produit")
	  //  @JsonIgnore
	    private List<Commande> listCommand;

}
