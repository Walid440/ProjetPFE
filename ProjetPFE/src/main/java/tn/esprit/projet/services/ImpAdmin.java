package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Admin;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.repositories.AdminRepository;
import tn.esprit.projet.repositories.ClientRepository;
@Service
public class ImpAdmin implements InterAdmin {
	
	
	 @Autowired
	    private AdminRepository AdminRep;

	  @Override
	    public List<Admin> getAll() {
	        return (List<Admin>) AdminRep.findAll();
	    }
	 
 
 
	@Override
	public Admin AddAdmin(Admin C) {
		// TODO Auto-generated method stub
		Admin client=AdminRep.save(C);
		return client;
	}
	  @Override
	    public Optional<Admin> getAdminById( long id)
	    {
	         
	        Optional<Admin> clt = AdminRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteAdmin(Long id) {
	        AdminRep.deleteById(id);
	    }
	  @Override
	    public Admin UpdateAdmin(Admin R,Long Id) {
	  
	        Admin Res= AdminRep.findById(Id).orElse(null);
	    
	       Res.setNom(R.getNom());
	       Res.setPrenom(R.getPrenom());
	       Res.setAdresse(R.getAdresse());
	       Res.setTelephone(R.getTelephone());
	       Res.setEmail(R.getEmail());
 	    	 
	       AdminRep.save(Res);
	        return null;
	    }

}
