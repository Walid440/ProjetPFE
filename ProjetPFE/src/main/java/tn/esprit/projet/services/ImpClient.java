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
	        return (List<Client>) ClientRep.findAll();
	    }
	 
 
 
	@Override
	public Client AddClient(Client C) {
		// TODO Auto-generated method stub
		Client client=ClientRep.save(C);
		return client;
	}
	  @Override
	    public Optional<Client> getClientById( long id)
	    {
	         
	        Optional<Client> clt = ClientRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteClient(Long id) {
	        ClientRep.deleteById(id);
	    }
	  @Override
	    public Client UpdateClient(Client R,Long Id) {
	  
	        Client Res= ClientRep.findById(Id).orElse(null);
	    
	       Res.setNom(R.getNom());
	       Res.setPrenom(R.getPrenom());
	       Res.setAdresse(R.getAdresse());
	       Res.setTelephone(R.getTelephone());
	       Res.setEmail(R.getEmail());
 	    	 
	       ClientRep.save(Res);
	        return null;
	    }

}
