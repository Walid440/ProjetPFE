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
   
}
