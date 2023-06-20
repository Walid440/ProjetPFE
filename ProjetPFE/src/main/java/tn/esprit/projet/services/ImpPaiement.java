package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.PaiementRepository;
@Service
public class ImpPaiement implements InterPaiement{
	
	
	 @Autowired
	    private PaiementRepository PaiRep;

	  @Override
	    public List<Paiement> getAll() {
	        return (List<Paiement>) PaiRep.findAll();
	    }
	 
 
 
	@Override
	public Paiement AddPaiement(Paiement C) {
		// TODO Auto-generated method stub
		Paiement P=PaiRep.save(C);
		return P;
	}
	   

}
