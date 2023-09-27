package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.ProduitRepository;
@Service
public class ImpProduit implements InterProduit {
	
	
	 @Autowired
	    private ProduitRepository ProduitRep;

	  @Override
	    public List<Produit> getAll() {
	        return (List<Produit>) ProduitRep.findAll();
	    }
	 
 
 
	@Override
	public Produit AddProduit(Produit C) {
		// TODO Auto-generated method stub
		Produit prod=ProduitRep.save(C);
		return prod;
	}
	  @Override
	    public Optional<Produit> getProduitById( long id)
	    {
	         
	        Optional<Produit> clt = ProduitRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteProduit(Long id) {
	        ProduitRep.deleteById(id);
	    }
	  @Override
	    public Produit UpdateProduit(Produit R) {
	  
	        //Produit Res= ProduitRep.findById(Id).orElse(null);
	    
	     /* Res.setAnnee(R.getAnnee());
	      Res.setNomProd(R.getNomProd());
 	      Res.setModele(R.getModele()); 
 	      Res.setMarque(R.getMarque());
 	      Res.setPrix(R.getPrix());
 	    	 */
	       
	        return ProduitRep.save(R);
	    }

}
