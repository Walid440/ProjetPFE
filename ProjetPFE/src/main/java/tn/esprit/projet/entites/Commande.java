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
	 
	 
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<LivraisonProd> LivProd;
    
  @ManyToMany(mappedBy="com",fetch=FetchType.LAZY)
    //@JsonIgnore
    private List<Paiement> paie;

@Override
public String toString() {
	return "Commande [id=" + id + ", client=" + client + ", LivProd=" + LivProd + ", paie=" + paie + "]";
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public List<LivraisonProd> getLivProd() {
	return LivProd;
}

public void setLivProd(List<LivraisonProd> livProd) {
	LivProd = livProd;
}

public Commande(long id, Client client, List<LivraisonProd> livProd, List<Paiement> paie) {
	super();
	this.id = id;
	this.client = client;
	LivProd = livProd;
	this.paie = paie;
}

public List<Paiement> getPaie() {
	return paie;
}

public void setPaie(List<Paiement> paie) {
	this.paie = paie;
}
    
  
    
}
