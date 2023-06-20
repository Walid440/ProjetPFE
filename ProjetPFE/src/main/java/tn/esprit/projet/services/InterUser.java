package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.User;

 
public interface InterUser  {

	List<User> getAll();

	User AddUser(User C);

	Optional<User> getUserById(long id);

	void DeleteUser(Long id);

	User UpdateUser(User R, Long Id);
	
	
	
	 

	 
}
