package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
public interface InterClient  {
	
	
	
	List<Client> getAll();

	Optional<Client> getClientById(long id);

	public Client AddPassengers(Client listP, Long idR, Long ferryId);
}
