package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;

 
public interface InterClient  {
	
	
	
	List<Client> getAll();

	Optional<Client> getClientById(long id);

	Client AddClient(Client C);

	void DeleteClient(Long id);

	Client UpdateClient(Client R, Long Id);

	 
}
