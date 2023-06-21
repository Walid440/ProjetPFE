package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.CommandeRepository;
@Service
public class ImpCommande implements InterCommande {
	
	
	 @Autowired
	    private CommandeRepository ComRep;

	  @Override
	    public List<Commande> getAll() {
	        return (List<Commande>) ComRep.findAll();
	    }
	 
 
 
	@Override
	public Commande AddCommande(Commande C) {
		// TODO Auto-generated method stub
		Commande com=ComRep.save(C);
		return com;
	}
	  @Override
	    public Optional<Commande> getCommandeById( long id)
	    {
	         
	        Optional<Commande> clt = ComRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteCommande(Long id) {
	        ComRep.deleteById(id);
	    }
	  @Override
	    public Commande UpdateCommande(Commande R,Long Id) {
	  
	        Commande Res= ComRep.findById(Id).orElse(null);
	    
	      /* Res.setClient(R.getClient());
	       Res.setPaie((List<Paiement>) R.getClient());
 	       Res.setLivProd(R.getLivProd());*/
	       ComRep.save(Res);
	        return null;
	    }

}
