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
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterOffre;
import tn.esprit.projet.services.InterProduit;

 
@RestController
@CrossOrigin("*")
public class ProduitController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterProduit ProdService;
   
    
    @PutMapping(value = "/UpdateProduit/{idF}")
    @ResponseBody
    public Produit Update (@RequestBody Produit R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return ProdService.UpdateProduit(R, idF) ;
    }
    
    
	@RequestMapping("/AllProd")
	@ResponseBody
	public  List<Produit> getAllProd()
	{
		   
    	List<Produit> offre=ProdService.getAll();
		return   offre ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateProd")
    @ResponseBody
    public Produit Create (@RequestBody Produit X)
    {
        return ProdService.AddProduit(X);
    }
	 @GetMapping("/getIdProd/{id}")
	 @ResponseBody
	 public Optional<Produit> getProdById(@PathVariable(value = "id") long Id)
	         
	 {
	     return ProdService.getProduitById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteProd/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	    	ProdService.DeleteProduit(idR);
	    }
}
