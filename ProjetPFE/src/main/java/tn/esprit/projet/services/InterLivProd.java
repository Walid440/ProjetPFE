package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.LivraisonProd;
import tn.esprit.projet.entites.User;

 
public interface InterLivProd  {

	List<LivraisonProd> getAll();

	LivraisonProd AddLivProd(LivraisonProd C);

	Optional<LivraisonProd> getLivraisonById(long id);

	void DeleteLivraisonProd(Long id);

	LivraisonProd UpdateLivraisonProd(LivraisonProd R, Long Id);

 
	
	
	
 

	 
}
