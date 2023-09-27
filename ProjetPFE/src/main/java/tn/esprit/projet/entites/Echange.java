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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="echange")
public class Echange  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEchange;
	
	 
    
    @Column(length = 25)
   private String proprietaire1;
   
   @Column(length = 25)
    private String marque1;
    @Column(length = 25)
    private String model1;
    @Column(length = 25)
    private Number annee1;
    @Column(length = 25)
    private String proprietaire2;
    @Column(length = 25)
    private String marque2;
    @Column(length = 35)
    private String model2;
    @Column(length = 25)
    private Number annee2;
    @Column(length = 25)
    private Date dateEchange;
    @Column(length = 25)
    private String lieuEchange;
    @Column(length = 25)
    private String prix;


    @OneToOne 
    private Offre offre;
    @ManyToOne
    private Client client;
    
    private StatusVoiture statusEchange;

	public long getIdEchange() {
		return idEchange;
	}

	public void setIdEchange(long idEchange) {
		this.idEchange = idEchange;
	}

	public String getProprietaire1() {
		return proprietaire1;
	}

	public void setProprietaire1(String proprietaire1) {
		this.proprietaire1 = proprietaire1;
	}

	public String getMarque1() {
		return marque1;
	}

	public void setMarque1(String marque1) {
		this.marque1 = marque1;
	}

	public String getModel1() {
		return model1;
	}

	public void setModel1(String model1) {
		this.model1 = model1;
	}

	public Number getAnnee1() {
		return annee1;
	}

	public void setAnnee1(Number annee1) {
		this.annee1 = annee1;
	}

	public String getProprietaire2() {
		return proprietaire2;
	}

	public void setProprietaire2(String proprietaire2) {
		this.proprietaire2 = proprietaire2;
	}

	public String getMarque2() {
		return marque2;
	}

	public void setMarque2(String marque2) {
		this.marque2 = marque2;
	}

	public String getModel2() {
		return model2;
	}

	public void setModel2(String model2) {
		this.model2 = model2;
	}

	public Number getAnnee2() {
		return annee2;
	}

	public void setAnnee2(Number annee2) {
		this.annee2 = annee2;
	}

	public Date getDateEchange() {
		return dateEchange;
	}

	public void setDateEchange(Date dateEchange) {
		this.dateEchange = dateEchange;
	}

	public String getLieuEchange() {
		return lieuEchange;
	}

	public void setLieuEchange(String lieuEchange) {
		this.lieuEchange = lieuEchange;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public StatusVoiture getStatusEchange() {
		return statusEchange;
	}

	public void setStatusEchange(StatusVoiture statusEchange) {
		this.statusEchange = statusEchange;
	}

	public Echange(long idEchange, String proprietaire1, String marque1, String model1, Number annee1,
			String proprietaire2, String marque2, String model2, Number annee2, Date dateEchange, String lieuEchange,
			Offre offre, Client client, StatusVoiture statusEchange) {
		super();
		this.idEchange = idEchange;
		this.proprietaire1 = proprietaire1;
		this.marque1 = marque1;
		this.model1 = model1;
		this.annee1 = annee1;
		this.proprietaire2 = proprietaire2;
		this.marque2 = marque2;
		this.model2 = model2;
		this.annee2 = annee2;
		this.dateEchange = dateEchange;
		this.lieuEchange = lieuEchange;
		this.offre = offre;
		this.client = client;
		this.statusEchange = statusEchange;
	}

	@Override
	public String toString() {
		return "Echange [idEchange=" + idEchange + ", proprietaire1=" + proprietaire1 + ", marque1=" + marque1
				+ ", model1=" + model1 + ", annee1=" + annee1 + ", proprietaire2=" + proprietaire2 + ", marque2="
				+ marque2 + ", model2=" + model2 + ", annee2=" + annee2 + ", dateEchange=" + dateEchange
				+ ", lieuEchange=" + lieuEchange + ", offre=" + offre + ", client=" + client + ", statusEchange="
				+ statusEchange + "]";
	}

	public Echange() {
		super();
		 
	}

 
	 

}
