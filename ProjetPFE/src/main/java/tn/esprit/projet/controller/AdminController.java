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

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.services.InterClient;

 
@RestController
@CrossOrigin("*")
public class AdminController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterClient ClientService;
   
    
    @PutMapping(value = "/UpdateClient/{idF}")
    @ResponseBody
    public Client Update (@RequestBody Client R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return ClientService.UpdateClient(R, idF) ;
    }
    
    
	@RequestMapping("/AllClient")
	@ResponseBody
	public  List<Client> getAllClient()
	{
		   
    	List<Client> client=ClientService.getAll();
		return   client ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateClient")
    @ResponseBody
    public Client Create (@RequestBody Client X)
    {
        return ClientService.AddClient(X);
    }
	 @GetMapping("/getIdClient/{id}")
	 @ResponseBody
	 public Optional<Client> getClientById(@PathVariable(value = "id") long Id)
	         
	 {
	     return ClientService.getClientById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteClt/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	        ClientService.DeleteClient(idR);
	    }
}
