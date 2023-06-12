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
import jakarta.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLoc;
	@Column(length = 25)
	private Date DateDebut;
	@Column(length = 50)
	private Date DateFin;
	@Column(length = 100)
	private Date HeureDebut;
    @Column(length = 100)
	private Date HeureFin;
    @Column(length = 50)
	private String Lieu;
    @Column(length = 50)
	private String prix;
    
    
    private Status status;
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "Produit")
	 //   @JsonIgnore
	    private List<Commande> listCommand;

}
