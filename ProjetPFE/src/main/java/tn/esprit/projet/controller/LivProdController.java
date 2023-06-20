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
import tn.esprit.projet.entites.LivraisonProd;
import tn.esprit.projet.entites.User;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterLivProd;
import tn.esprit.projet.services.InterUser;

 
@RestController
@CrossOrigin("*")
public class LivProdController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterLivProd LivProdService;
   
    
    @PutMapping(value = "/UpdateLivProd/{idF}")
    @ResponseBody
    public LivraisonProd Update (@RequestBody LivraisonProd R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return LivProdService.UpdateLivraisonProd(R, idF) ;
    }
    
    
	@RequestMapping("/AllLivProd")
	@ResponseBody
	public  List<LivraisonProd> getAllClient()
	{
		   
    	List<LivraisonProd> user=LivProdService.getAll();
		return   user ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateLivprod")
    @ResponseBody
    public LivraisonProd Create (@RequestBody LivraisonProd X)
    {
        return LivProdService.AddLivProd(X);
    }
	 @GetMapping("/getIdLivProd/{id}")
	 @ResponseBody
	 public Optional<LivraisonProd> getLivProdById(@PathVariable(value = "id") long Id)
	         
	 {
	     return LivProdService.getLivraisonById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteLivProd/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	        LivProdService.DeleteLivraisonProd(idR);
	    }
}
