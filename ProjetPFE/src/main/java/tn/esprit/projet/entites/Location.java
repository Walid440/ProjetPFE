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
    
    
    private Status statusLoc;
    @OneToOne
  
    private Offre offre;

	public long getIdLoc() {
		return idLoc;
	}


	public void setIdLoc(long idLoc) {
		this.idLoc = idLoc;
	}


	public Date getDateDebut() {
		return DateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}


	public Date getDateFin() {
		return DateFin;
	}


	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}


	public Date getHeureDebut() {
		return HeureDebut;
	}


	public void setHeureDebut(Date heureDebut) {
		HeureDebut = heureDebut;
	}


	public Date getHeureFin() {
		return HeureFin;
	}


	public void setHeureFin(Date heureFin) {
		HeureFin = heureFin;
	}


	public String getLieu() {
		return Lieu;
	}


	public void setLieu(String lieu) {
		Lieu = lieu;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public Status getStatusLoc() {
		return statusLoc;
	}


	public void setStatusLoc(Status statusLoc) {
		this.statusLoc = statusLoc;
	}


	public Location(long idLoc, Date dateDebut, Date dateFin, Date heureDebut, Date heureFin, String lieu, String prix,
			Status statusLoc) {
		super();
		this.idLoc = idLoc;
		DateDebut = dateDebut;
		DateFin = dateFin;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		Lieu = lieu;
		this.prix = prix;
		this.statusLoc = statusLoc;
	}


	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
