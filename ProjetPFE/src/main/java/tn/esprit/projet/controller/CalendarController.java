package tn.esprit.projet.controller;

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

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.services.CalendarService;
import tn.esprit.projet.services.InterClient;

 
@RestController
@CrossOrigin("*")
public class CalendarController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private CalendarService CalServ;
   
    
   
    
    
	 
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateCalendar")
    @ResponseBody
    public Calendar Create (@RequestBody Calendar X)
    {
        return CalServ.AddCalendar(X);
    }
	
	@CrossOrigin("http://localhost:8090")
	 @GetMapping("/AllCalendar")
	 @ResponseBody
	 public List<Calendar> getAll()
	         
	 {    	List<Calendar> cal=CalServ.getAllCal();

	     return cal;
	 }
	    
}
