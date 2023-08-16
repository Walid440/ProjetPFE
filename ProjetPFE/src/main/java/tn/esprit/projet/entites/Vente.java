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
import jakarta.persistence.OneToOne;

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
   
    @OneToOne
	private Vente vente;
    @ManyToOne
    private Client client;
    
    private StatusVoiture statusVente;

	public long getIdEchange() {
		return idEchange;
	}

	public void setIdEchange(long idEchange) {
		this.idEchange = idEchange;
	}

	public long getVoitureA() {
		return VoitureA;
	}

	public void setVoitureA(long voitureA) {
		VoitureA = voitureA;
	}

	public Date getDateVente() {
		return DateVente;
	}

	public void setDateVente(Date dateVente) {
		DateVente = dateVente;
	}

	public String getClientAcheteur() {
		return ClientAcheteur;
	}

	public void setClientAcheteur(String clientAcheteur) {
		ClientAcheteur = clientAcheteur;
	}

	public String getAgentDeVente() {
		return AgentDeVente;
	}

	public void setAgentDeVente(String agentDeVente) {
		AgentDeVente = agentDeVente;
	}

	public String getStatutVente() {
		return StatutVente;
	}

	public void setStatutVente(String statutVente) {
		StatutVente = statutVente;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public StatusVoiture getStatusVente() {
		return statusVente;
	}

	public void setStatusVente(StatusVoiture statusVente) {
		this.statusVente = statusVente;
	}

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(long idEchange, long voitureA, Date dateVente, String clientAcheteur, String agentDeVente,
			String statutVente, String prix, Vente vente, Client client, StatusVoiture statusVente) {
		super();
		this.idEchange = idEchange;
		VoitureA = voitureA;
		DateVente = dateVente;
		ClientAcheteur = clientAcheteur;
		AgentDeVente = agentDeVente;
		StatutVente = statutVente;
		this.prix = prix;
		this.vente = vente;
		this.client = client;
		this.statusVente = statusVente;
	}

	@Override
	public String toString() {
		return "Vente [idEchange=" + idEchange + ", VoitureA=" + VoitureA + ", DateVente=" + DateVente
				+ ", ClientAcheteur=" + ClientAcheteur + ", AgentDeVente=" + AgentDeVente + ", StatutVente="
				+ StatutVente + ", prix=" + prix + ", vente=" + vente + ", client=" + client + ", statusVente="
				+ statusVente + "]";
	}
	 

}
