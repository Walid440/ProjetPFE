package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Paiement;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.PaiementRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class ImpPaiement implements InterPaiement{
	
	
	 @Autowired
	    private PaiementRepository PaiRep;

	  @Override
	    public List<Paiement> getAll() {
	        return (List<Paiement>) PaiRep.findAll();
	    }
	 
 
 
	@Override
	public Paiement AddPaiement(Paiement C) {
		// TODO Auto-generated method stub
		Paiement P=PaiRep.save(C);
		
		
		Stripe.apiKey = "sk_test_51LXCNzGIua3O4ypHXGsX16FkyNXEXIG8f432zIzdN63tgBnvrPYeKdPvYYkONxPyjGmZRWGkfkskKNLvmjljmHeC00ExAgPV0v";

		Map<String, Object> automaticPaymentMethods =
		  new HashMap<>();
		automaticPaymentMethods.put("enabled", true);
		Map<String, Object> params = new HashMap<>();
		params.put("amount", 2000);
		params.put("currency", "usd");
		params.put(
		  "automatic_payment_methods",
		  automaticPaymentMethods
		);

		try {
			PaymentIntent paymentIntent =
			  PaymentIntent.create(params);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return P;
	}
	   

}
