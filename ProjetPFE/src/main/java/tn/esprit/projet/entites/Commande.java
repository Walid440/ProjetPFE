package tn.esprit.projet.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
 
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 


enum VoyageType
{
    ROUNDTRIP,ONEWAY
}

@Entity
@Data
@Table(name = "Commande")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Commande    {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<LivraisonProd> LivProd;
    @ManyToMany(mappedBy="com",fetch=FetchType.LAZY)
    //@JsonIgnore
    private List<Paiement> paie;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonIgnore
    @Column(name="dateDebut")
    private LocalDateTime  dateDebut;
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name="dateFin")
    private LocalDateTime dateFin;

 

    @Column(name = "Prix")
    private String prix;

    @Column(name = "Status")
    private String status;

    
    
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 

	@Override
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", LivProd=" + LivProd + ", paie=" + paie + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", prix=" + prix
				+ ", status=" + status + "]";
	}

	public List<Paiement> getPaie() {
		return paie;
	}

	public void setPaie(List<Paiement> paie) {
		this.paie = paie;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
    
 

   


}
