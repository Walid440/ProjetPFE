package tn.esprit.projet.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;

 
public interface InterCommande  {
	
	
	
 


	Commande AddCommande(Commande C,long id,LocalDateTime start,LocalDateTime end);

	Optional<Commande> getCommandeById(long id);

	 List<Commande> getAllCom();

	void DeleteCommande(Long id);

	Commande UpdateCommande(Commande R, Long Id);

	public List<Commande> findByEventDateTimeBetween(LocalDateTime start, LocalDateTime end);
 
	 
}
