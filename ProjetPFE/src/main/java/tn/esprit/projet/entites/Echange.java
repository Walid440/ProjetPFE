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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Echange implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEchange;
	
	private long VoitureA;
	private long VoitureB;
	@Column(length = 25)
	private Date DateEchange;
 
    @Column(length = 100)
	private Date HeureFin;
    @Column(length = 50)
	private String ValeurVoitue1;
    @Column(length = 50)
	private String prix;
    
    @ManyToOne
    private Client client;
    
    private StatusVoiture statusVoi;
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "Produit")
	  
	    private List<Commande> listCommand;

}
