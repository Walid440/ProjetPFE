package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.repositories.ClientRepository;
@Service
public class ImpClient implements InterClient {
	
	
	 @Autowired
	    private ClientRepository ClientRep;

	@Override
 public List<Client> getAll() {
		// TODO Auto-generated method stub
		 
		return (List<Client>)ClientRep.findAll();
	}

	@Override
	public Optional<Client> getClientById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Client AddPassengers(Client listP, Long idR, Long ferryId) {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
