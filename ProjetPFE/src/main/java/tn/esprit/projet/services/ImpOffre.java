package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.OffreRepository;
@Service
public class ImpOffre implements InterOffre {
	
	
	 @Autowired
	    private OffreRepository OffRep;

	  @Override
	public
	     List<Offre> getAll() {
	        return (List<Offre>) OffRep.findAll();
	    }
	 
 
 
	@Override
	public Offre AddOffre(Offre C) {
		// TODO Auto-generated method stub
		Offre offre=OffRep.save(C);
		return offre;
	}
	  @Override
	    public Optional<Offre> getOffreById( long id)
	    {
	         
	        Optional<Offre> clt = OffRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteOffre(Long id) {
	        OffRep.deleteById(id);
	    }
	  @Override
	    public Offre UpdateOffre(Offre R,Long Id) {
	  
	        Offre Res= OffRep.findById(Id).orElse(null);
	    
	       Res.setAdresse(R.getAdresse());
	       Res.setNomOffre(R.getNomOffre());
	       Res.setEchange(R.getEchange());
	       Res.setLocation(R.getLocation());
	       Res.setVente(R.getVente());
	       OffRep.save(Res);
	        return null;
	    }

}
