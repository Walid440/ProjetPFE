package tn.esprit.projet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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

import tn.esprit.projet.entites.ChatMessage;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.services.InterClient;

 
@RestController
@CrossOrigin("*")
public class ChatController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterClient ClientService;
   
    
  @MessageMapping("/chat.sendMessage")
  @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chat) {
		return chat;
    	
    	
    }
  @MessageMapping("/chat.addUser")
  @SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chat ,SimpMessageHeaderAccessor headerAccessor) {
	
	  //ajouter username au web socket
	  
	  headerAccessor.getSessionAttributes().put("username",chat.getSender());
	  
	  return chat;
		
	}
  
	  
}
