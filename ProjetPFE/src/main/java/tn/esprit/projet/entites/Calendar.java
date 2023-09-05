package tn.esprit.projet.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

 

@Entity
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
/*	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;*/
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
	private List<Produit> produit;
	
	public Calendar() {
		super();
	}
	
	public Calendar(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", name=" + name + ", produit=" + produit + "]";
	}


	 
	
	

}
