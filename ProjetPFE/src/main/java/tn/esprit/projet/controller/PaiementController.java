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
  @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private InterPaiement PaiementService;
   
 
    
	@RequestMapping("/AllPaiement")
	@ResponseBody
	public  List<Paiement> getAllPaie()
	{
		   
    	List<Paiement> Paie=PaiementService.getAll();
		return   Paie ;	
	}
	@GetMapping("/pay/{price}/{email}")
	 @ResponseBody
	 public void addpayement( @PathVariable(value = "price") String price,@PathVariable String email)   {
	 	Stripe.apiKey = "sk_test_51LXCNzGIua3O4ypHXGsX16FkyNXEXIG8f432zIzdN63tgBnvrPYeKdPvYYkONxPyjGmZRWGkfkskKNLvmjljmHeC00ExAgPV0v"; 
	 	
	 	
			// `source` is obtained with Stripe.js; see https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
			Map<String, Object> params = new HashMap<>();
			params.put("amount", price);
			params.put("currency", "usd");
			params.put("source", "tok_mastercard");
			params.put("description",email);
 jakarta.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				    MimeMessageHelper helper;
				    
				    
				    
				   
			  
				
				try {
	try {
		Charge charge = Charge.create(params);
	} catch (StripeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
					
						helper = new MimeMessageHelper(mimeMessage, true); 
					helper.setSubject("Notif Payement+ QRcode");
					    helper.setText("Payement de "+price+" effectué avec succés  Merci de n'est pas répondre au message ci-joint votre Qrcode ");
					 helper.setTo(email);
					 javaMailSender.send(mimeMessage);
				 
					}  catch (MessagingException e) {
						// TODO Auto-generated catch block
						
					}
				   /* FileSystemResource file = new FileSystemResource(new File("./src/main/resources/QRCode.png"));
				    helper.addAttachment("CoolImage.jpg", file);*/ 
				  
			
				
			 
			}

		//	Company com = comrep.findById(id).get();
	   //  c.setCompanies(com);
	  
	   // c.setContent(aes.decrypt(c.getContent()));
	    
	  
		
	   
	
	
	
}