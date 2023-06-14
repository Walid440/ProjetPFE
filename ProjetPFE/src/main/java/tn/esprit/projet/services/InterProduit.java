package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Produit;

 
public interface InterProduit  {

	List<Produit> getAll();

	Produit AddProduit(Produit C);

	Optional<Produit> getProduitById(long id);

	void DeleteProduit(Long id);

	Produit UpdateProduit(Produit R, Long Id);
	
	
	
 
	 
}
