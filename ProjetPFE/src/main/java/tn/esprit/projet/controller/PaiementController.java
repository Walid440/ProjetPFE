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
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterOffre;
import tn.esprit.projet.services.InterPaiement;
import tn.esprit.projet.services.InterProduit;

 
@RestController
@CrossOrigin("*")
public class PaiementController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterPaiement PaiementService;
   
 
    
	@RequestMapping("/AllPaiement")
	@ResponseBody
	public  List<Paiement> getAllPaie()
	{
		   
    	List<Paiement> Paie=PaiementService.getAll();
		return   Paie ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreatePaiement")
    @ResponseBody
    public Paiement Create (@RequestBody Paiement X)
    {
        return PaiementService.AddPaiement(X);
    }
}