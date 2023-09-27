package tn.esprit.projet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.projet.entites.Location;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.repositories.LocationRepository;

@Component
@Slf4j
@EnableScheduling
@Service
public class ScheduledKm{
	@Autowired
	private LocationRepository locationRepo;

 
 
 

    @Autowired
  //  private KilometerService kilometerService;
private static final Logger logger=LoggerFactory.getLogger(ScheduledKm.class);
     
    @Scheduled(cron = "0/2 * * * * *")
    public void checkKilometerTask() {
    	
    	  List<Location> locations = locationRepo.findAll();

    	    for (Location location : locations) {
    	         
    	        if ((location.getKm_fin()-location.getKm_debut()> 5000)&&(location.getKm_fin()-location.getKm_debut()<= 10000)) {
    	              logger.info("Kilométrage supérieur à 5000 km   veuillez changer l'huile ");
    	        }
    	        else if ((location.getKm_fin()-location.getKm_debut()> 10000)&&(location.getKm_fin()-location.getKm_debut()<=15000))
    	        {
    	         
    	            logger.info("Kilométrage supérieur à 10000 km   veuillez changer des pneus ");
    	        }
    	        else if ((location.getKm_fin()-location.getKm_debut()> 15000)&&(location.getKm_fin()-location.getKm_debut()<= 20000))
        	    {
    	            logger.info("Kilométrage supérieur à 15000 km   veuillez changer  du filtre à air  ");
    	        }
    	        else if ((location.getKm_fin()-location.getKm_debut()> 20000)&&(location.getKm_fin()-location.getKm_debut()<= 50000))
    	    {
	            logger.info("Kilométrage supérieur à 20000 km   veuillez changer  du filtre à air  ");
	        }
    	    
    	        else if ((location.getKm_fin()-location.getKm_debut()> 50000)&&(location.getKm_fin()-location.getKm_debut()<=80000))
    	    {
	            logger.info("Kilométrage supérieur à 50000 km Veuillez changer Bougies d'allumage ");
	        }
    	        else  if (location.getKm_fin()-location.getKm_debut()> 80000)
    	    {
	            logger.info("Kilométrage supérieur à 80000 km Veuillez changer Courroie de distribution  ");
	        }
    	}
    	 
    }
}


        
    

