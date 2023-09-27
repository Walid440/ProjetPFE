package tn.esprit.projet.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterCommande;

 
@RestController
@CrossOrigin("*")
public class CommandeController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterCommande ComService;
  
    
    @PutMapping(value = "/UpdateCommande/{idF}")
    @ResponseBody
    public Commande Update (@RequestBody Commande R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return ComService.UpdateCommande(R, idF) ;
    }
    
    @CrossOrigin("http://localhost:8090")
	@RequestMapping("/allCom")
	@ResponseBody
	public  List<Commande> getAllCommande()
	{
		   
    	List<Commande> client=ComService.getAllCom();
		return   client ;	
	}
     
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateCommande/{start}/{end}/{idF}")
    @ResponseBody
    public Commande Create (@RequestBody Commande X, @PathVariable(value = "start") String  start,@PathVariable(value = "end") String  end,@PathVariable Long idF)
    {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		 
		String startDateTime = start;
		String endDateTime = end;
	  
	
		 
		 
			LocalDateTime start1 = LocalDateTime.parse(startDateTime, formatter);
			LocalDateTime end1 = LocalDateTime.parse(endDateTime, formatter);

        return ComService.AddCommande( X,idF,start1,end1);
         
         
    }
	 @GetMapping("/getIdCommande/{id}")
	 @ResponseBody
	 public Optional<Commande> getCommandeById(@PathVariable(value = "id") long Id)
	         
	 {
	     return ComService.getCommandeById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteCommande/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	    	ComService.DeleteCommande(idR);
	    }
	    
	    @CrossOrigin("http://localhost:8090")
	    @GetMapping("/search/commande/{start}/{end}" )
	    @ResponseBody

		public List<Commande> searchEvents(@PathVariable("start")  String  start,@PathVariable("end")  String  end) 
		{	
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			 
				String startDateTime = start;
				String endDateTime = end;
			
				 
				 
					LocalDateTime start1 = LocalDateTime.parse(startDateTime, formatter);
					LocalDateTime end1 = LocalDateTime.parse(endDateTime, formatter);
					List<Commande> calendarEvents = ComService.findByEventDateTimeBetween(start1, end1);
	 				return calendarEvents;
		}
}