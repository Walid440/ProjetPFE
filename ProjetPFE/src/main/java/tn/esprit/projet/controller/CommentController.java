package tn.esprit.projet.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

 
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import jakarta.mail.MessagingException;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Comment;
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterComment;
import tn.esprit.projet.services.InterOffre;
import tn.esprit.projet.services.InterPaiement;
import tn.esprit.projet.services.InterProduit;

 
@RestController
@CrossOrigin("*")
public class CommentController {
	 @Autowired
	    private InterComment CommentService;
	   
	   
	    
		@RequestMapping("/AllComment")
		@ResponseBody
		public  List<Comment> getAllComment()
		{
			   
	    	List<Comment> comment=CommentService.getAll();
			return   comment ;	
		}
		@CrossOrigin("http://localhost:8090")
	    @PostMapping(value = "/CreateComment")
	    @ResponseBody
	    public Comment Create (@RequestBody Comment X)
	    {
	        return CommentService.AddComment(X);
	    }
		  
	
	
	
}