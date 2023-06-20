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

import tn.esprit.projet.entites.Admin;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.services.InterAdmin;
import tn.esprit.projet.services.InterClient;

 
@RestController
@CrossOrigin("*")
public class AdminController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterAdmin AdminService;
   
    
    @PutMapping(value = "/UpdateAdmin/{idF}")
    @ResponseBody
    public Admin Update (@RequestBody Admin R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return AdminService.UpdateAdmin(R, idF) ;
    }
    
    
	@RequestMapping("/AllAdmin")
	@ResponseBody
	public  List<Admin> getAllAdmin()
	{
		   
    	List<Admin> client=AdminService.getAll();
		return   client ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateAdmin")
    @ResponseBody
    public Admin Create (@RequestBody Admin X)
    {
        return AdminService.AddAdmin(X);
    }
	 @GetMapping("/getIdAdmin/{id}")
	 @ResponseBody
	 public Optional<Admin> getAdminById(@PathVariable(value = "id") long Id)
	         
	 {
	     return AdminService.getAdminById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteAdmin/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	    	AdminService.DeleteAdmin(idR);
	    }
}
