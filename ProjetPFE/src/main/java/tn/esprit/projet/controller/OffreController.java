package tn.esprit.projet.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterOffre;

 
@RestController
@CrossOrigin("*")
public class OffreController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterOffre OffreService;
   
    
    @PutMapping(value = "/UpdateOffre/{idF}")
    @ResponseBody
    public Offre Update (@RequestBody Offre R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return OffreService.UpdateOffre(R, idF) ;
    }
    
    
    @CrossOrigin("http://localhost:8090")
    @GetMapping("/search/{dat}/{type}" )
    @ResponseBody

	public List<Offre> searchEvents(@PathVariable String  dat,@PathVariable String  type) 
	{	
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
			String startDateTime = dat;
			 
		
			 
			 
				LocalDate start1 = LocalDate.parse(startDateTime, formatter);
 				List<Offre> calendarEvents = OffreService.findByEventDateTimeBetween(start1,type);
 				return calendarEvents;
	}
	
	@RequestMapping("/AllOffre")
	@ResponseBody
	public  List<Offre> getAllOffre()
	{
		   
    	List<Offre> offre=OffreService.getAll();
		return   offre ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateOffre")
    @ResponseBody
    public Offre Create (@RequestBody Offre X)
    {
        return OffreService.AddOffre(X);
    }
	 @GetMapping("/getIdOffre/{id}")
	 @ResponseBody
	 public Optional<Offre> getOffreById(@PathVariable(value = "id") long Id)
	         
	 {
	     return OffreService.getOffreById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteOffre/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	    	OffreService.DeleteOffre(idR);
	    }
}
