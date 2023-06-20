package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.User;
import tn.esprit.projet.repositories.UserRepository;
 @Service
public class ImpUser implements InterUser {
	
	
	 @Autowired
	    private UserRepository UserRep;

	  @Override
	    public List<User> getAll() {
	        return (List<User>) UserRep.findAll();
	    }
	 
 
 
	@Override
	public User AddUser(User C) {
		// TODO Auto-generated method stub
		User User=UserRep.save(C);
		return User;
	}
	  @Override
	    public Optional<User> getUserById( long id)
	    {
	         
	        Optional<User> clt = UserRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteUser(Long id) {
	        UserRep.deleteById(id);
	    }
	  @Override
	    public User UpdateUser(User R,Long Id) {
	  
	        User Res= UserRep.findById(Id).orElse(null);
	    
	       Res.setAdmin(R.getAdmin());
	       Res.setAdresse(R.getAdresse());
	       Res.setClient(R.getClient());
	       Res.setEmail(R.getEmail());
	       Res.setPassword(R.getPassword());
	       Res.setTelephone(R.getTelephone());
 	    	 
	       UserRep.save(Res);
	        return null;
	    }

}
