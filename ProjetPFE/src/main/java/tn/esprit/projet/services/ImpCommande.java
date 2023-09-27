package tn.esprit.projet.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.entites.Location;
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.repositories.CalendarRepository;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.CommandeRepository;
import tn.esprit.projet.repositories.LocationRepository;
import tn.esprit.projet.repositories.ProduitRepository;
@Service
public class ImpCommande implements InterCommande {
	
	
	 @Autowired
	    private CommandeRepository ComRep;
	 @Autowired
	    private CalendarRepository CalRep;
	 @Autowired
	    private ProduitRepository prodRep;
	  @Override
	public List<Commande> getAllCom() {
	        return (List<Commande>) ComRep.findAll();
	    }
	 	@Autowired
			private LocationRepository LocationRepo;
 
 
		@Override
		public Commande AddCommande(Commande C,long id,LocalDateTime start,LocalDateTime end) {
			// TODO Auto-generated method stub
			Commande com=ComRep.save(C);
			Calendar ca=new Calendar();
		
			
		Produit prod = prodRep.findById(id).orElse(null);
			Calendar c=new Calendar();
			
			 c.setStart(com.getDateDebut());
			 c.setEnd(com.getDateFin());
			 c.setColor("red");
			 c.setTitle(prod.getModele()+" "+prod.getMarque()+" "+prod.getAnnee());
			 c.setCommande(com);
			 com.setProd(prod);
			 CalRep.save(c);
			 
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
	    
	       Res.setClient(R.getClient());
	       Res.setPaie((List<Paiement>) R.getClient());
 	       Res.setLivProd(R.getLivProd());
 	       Res.setDateDebut(R.getDateDebut());
 	       Res.setDateFin(R.getDateFin());
 	       Res.setPrix(R.getPrix());
 	       Res.setStatus(R.getStatus());
 	      
 	      
	      
	        return  ComRep.save(Res);
	    }


	 
	@Override
	public List<Commande> findByEventDateTimeBetween(LocalDateTime start, LocalDateTime end) {
	 
		 return ComRep.findAllWithCreationDateTimeBefore(start,end);
	}

}
