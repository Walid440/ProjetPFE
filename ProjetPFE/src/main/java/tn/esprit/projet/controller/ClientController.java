package tn.esprit.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.services.InterClient;

@RequestMapping("/Client")
@Controller
@CrossOrigin("*")
public class ClientController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterClient ClientService;
    
	@GetMapping("/getAllClient")
	@ResponseBody
	  List<Client> getAllClient()
	{
		 List<Client> listClient = ClientService.getAll();
		return listClient; 	
	}
   
}
