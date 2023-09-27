package tn.esprit.projet.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 

import lombok.extern.slf4j.Slf4j;
import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.OffreRepository;
import javax.servlet.ServletContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 

import lombok.extern.slf4j.Slf4j;
 
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
 

@Service
@Slf4j
public class ImpOffre implements InterOffre {
	 @Autowired
	    ServletContext context;
	
	 @Autowired
	    private OffreRepository OffRep;

	  @Override
	public
	     List<Offre> getAll() {
	        return (List<Offre>) OffRep.findAll();
	    }
	 
  
	           
	@Override
	public Offre AddOffre(Offre C,MultipartFile file,String photo) throws IOException {
		 Path uploadPath = Paths.get("src/main/resources/static/Files-Upload");
		// Offre fe = new ObjectMapper().readValue(C, Offre.class);
		   String newFileName="";
		 Offre offre=new Offre();
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	 
	        String fileCode = RandomStringUtils.randomAlphanumeric(8);
	         
	        try (InputStream inputStream = file.getInputStream()) {
	            Path filePath = uploadPath.resolve(photo);
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	            String filename = file.getOriginalFilename();
	             newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	         
	        } catch (IOException ioe) {       
	            throw new IOException("Could not save file: " + photo, ioe);
	        }
	         
 		
 		if(C.getEchange()!=null)
		{
			C.setphoto2("echange.png");
			 
			
		}
		else if(C.getVente()!=null)
		{
			C.setphoto2("vente.png");
			
		}
		else if(C.getLocation()!=null)
		{
			C.setphoto2("location.png");
			
		} 
		
 //   offre.setNomOffre(C.getNomOffre());
C.setPhoto(newFileName);
		return OffRep.save(C);
	}
	  @Override
	    public Optional<Offre> getOffreById( long id)
	    {
	         
	        Optional<Offre> clt = OffRep.findById( id);
	                
	        return clt;
	    }
	  @Override
	    public void DeleteOffre(Long id) {
	        OffRep.deleteById(id);
	    }
	  @Override
	    public Offre UpdateOffre(Offre R) {
	  
	        //Offre Res= OffRep.findById(Id).orElse(null);
	    
	      /* Res.setAdresse(R.getAdresse());
	       Res.setNomOffre(R.getNomOffre());
	       Res.setEchange(R.getEchange());
	       Res.setLocation(R.getLocation());
	       Res.setVente(R.getVente());
	       */
	       OffRep.save(R);
	        return null;
	    }
	  public List<Offre> findByEventDateTimeBetween(LocalDate dat,String type,String ville)
		{
			
			return OffRep.findAllWithCreationDateTimeBefore(dat,type,ville);
		}
 
}
