package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Paiement;

 
public interface InterPaiement  {

	List<Paiement> getAll();

	Paiement AddPaiement(Paiement C);
	
	
	
	

	 
}
