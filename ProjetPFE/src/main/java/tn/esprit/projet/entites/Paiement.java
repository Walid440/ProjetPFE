package tn.esprit.projet.entites;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 250)
	
	private String Amount;
	@Column(length = 50)
	private String payementDate;
	
 @JsonIgnore
	 @ManyToMany(fetch = FetchType.LAZY)
	    
 
	    private List<Commande> com;


	public Paiement(long id, String amount, String payementDate, List<Commande> com) {
		super();
		this.id = id;
		Amount = amount;
		this.payementDate = payementDate;
		this.com = com;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAmount() {
		return Amount;
	}


	public void setAmount(String amount) {
		Amount = amount;
	}


	public String getPayementDate() {
		return payementDate;
	}


	public void setPayementDate(String payementDate) {
		this.payementDate = payementDate;
	}


	public List<Commande> getCom() {
		return com;
	}


	public void setCom(List<Commande> com) {
		this.com = com;
	}


	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Paiement [id=" + id + ", Amount=" + Amount + ", payementDate=" + payementDate + ", com=" + com + "]";
	}
	 
	 
	 
}
