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
import tn.esprit.projet.entites.User;
import tn.esprit.projet.services.InterClient;
import tn.esprit.projet.services.InterUser;

 
@RestController
@CrossOrigin("*")
public class UserController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterUser UserService;
   
    
    @PutMapping(value = "/UpdateUser/{idF}")
    @ResponseBody
    public User Update (@RequestBody User R, @PathVariable Long idF)
    {//ReservationService.UpdateEvent(10);
    
        return UserService.UpdateUser(R, idF) ;
    }
    
    
	@RequestMapping("/AllUser")
	@ResponseBody
	public  List<User> getAllClient()
	{
		   
    	List<User> user=UserService.getAll();
		return   user ;	
	}
	@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateUser")
    @ResponseBody
    public User Create (@RequestBody User X)
    {
        return UserService.AddUser(X);
    }
	 @GetMapping("/getIdUser/{id}")
	 @ResponseBody
	 public Optional<User> getClientById(@PathVariable(value = "id") long Id)
	         
	 {
	     return UserService.getUserById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteClt/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	        UserService.DeleteUser(idR);
	    }
}
