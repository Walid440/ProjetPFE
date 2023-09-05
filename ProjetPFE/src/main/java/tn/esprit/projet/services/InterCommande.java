package tn.esprit.projet.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;

 
public interface InterCommande  {
	
	
	
 

	Commande AddCommande(Commande C);

	Optional<Commande> getCommandeById(long id);

	List<Commande> getAll();

	void DeleteCommande(Long id);

	Commande UpdateCommande(Commande R, Long Id);

	public List<Commande> findByEventDateTimeBetween(LocalDateTime start, LocalDateTime end);
	 
}
