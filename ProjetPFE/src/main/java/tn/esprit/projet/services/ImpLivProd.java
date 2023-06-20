package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.LivraisonProd;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.LivraisonProdRepository;
@Service
public class ImpLivProd implements InterLivProd {
	
	
	 @Autowired
	    private LivraisonProdRepository LivProdRep;

	  @Override
	    public List<LivraisonProd> getAll() {
	        return (List<LivraisonProd>) LivProdRep.findAll();
	    }
	 
 
 
	@Override
	public LivraisonProd AddLivProd(LivraisonProd C) {
		// TODO Auto-generated method stub
		LivraisonProd client=LivProdRep.save(C);
		return client;
	}
	  @Override
	    public Optional<LivraisonProd> getLivraisonById( long id)
	    {
	         
	        Optional<LivraisonProd> clt = LivProdRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteLivraisonProd(Long id) {
	        LivProdRep.deleteById(id);
	    }
	  @Override
	    public LivraisonProd UpdateLivraisonProd(LivraisonProd R,Long Id) {
	  
		  LivraisonProd Res= LivProdRep.findById(Id).orElse(null);
	    
	       Res.setAdresse(R.getAdresse());
	       Res.setDate(R.getDate());
	   
 	    	 
	       LivProdRep.save(Res);
	        return null;
	    }

}
