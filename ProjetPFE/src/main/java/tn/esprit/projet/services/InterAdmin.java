package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Admin;
import tn.esprit.projet.entites.Client;

 
public interface InterAdmin  {

	List<Admin> getAll();

 
	Optional<Admin> getAdminById(long id);

	void DeleteAdmin(Long id);

	Admin UpdateAdmin(Admin R, Long Id);

	Admin AddAdmin(Admin C);
	
	
 

	 
}
