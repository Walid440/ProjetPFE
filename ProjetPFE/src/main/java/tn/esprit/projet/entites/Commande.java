package tn.esprit.projet.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
 
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



 

@Entity
@Data
@Table(name = "Commande")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@AllArgsConstructor
public class Commande  implements Serializable    {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 @JsonIgnore
    @ManyToOne

    private Client client;
	 
	 @ManyToMany
    private List<LivraisonProd> LivProd;
	 // @JsonIgnore
    @ManyToMany(mappedBy = "com", cascade = CascadeType.ALL)
    
    private List<Paiement> paie;
    @JsonDeserialize
    @JsonIgnoreProperties
    @JsonSerialize // Vous pouvez ajouter cette annotation pour la sérialisation
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "dateDebut")
    private LocalDateTime dateDebut;
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "dateFin")
    private LocalDateTime dateFin;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
     private List<Calendar> lisCom;

    @ManyToOne
 	    @JsonIgnore
 	    private Produit prod;
   
    public List<Calendar> getLisCom() {
		return lisCom;
	}

	public void setLisCom(List<Calendar> lisCom) {
		this.lisCom = lisCom;
	}

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

 
 

    @Column(name = "Prix")
    private String prix;

    @Column(name = "Status")
    private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Paiement> getPaie() {
		return paie;
	}

	public void setPaie(List<Paiement> paie) {
		this.paie = paie;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Commande(Long id, Client client, List<LivraisonProd> livProd, List<Paiement> paie, LocalDateTime dateDebut,
			LocalDateTime dateFin, List<Calendar> lisCom, Produit prod, List<Calendar> listCal, String prix,
			Status status) {
		super();
		this.id = id;
		this.client = client;
		LivProd = livProd;
		this.paie = paie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lisCom = lisCom;
		this.prod = prod;
		 
		this.prix = prix;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Commande id=" + id + ", client=" + client + ", LivProd=" + LivProd + ", paie=" + paie + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", lisCom=" + lisCom + ", prod=" + prod + ", listCal=" 
				+ ", prix=" + prix + ", status=" + status + "";
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

    
     
 

   


}
