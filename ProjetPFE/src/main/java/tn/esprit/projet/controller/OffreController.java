package tn.esprit.projet.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

 
 
import tn.esprit.projet.entites.Offre;
import tn.esprit.projet.repositories.OffreRepository;
 
import tn.esprit.projet.services.InterOffre;

 
@RestController
@CrossOrigin("*")
public class OffreController {
  /*  @Autowired
    private JavaMailSender javaMailSender;*/
    @Autowired
    private InterOffre OffreService;
    @Autowired
    ServletContext context;
    @Autowired
    private OffreRepository OffRep;
    @CrossOrigin("*")
    @PutMapping("offre/UpdateOffre")
    @ResponseBody
    public Offre Update (@RequestBody Offre R)
    {//ReservationService.UpdateEvent(10);
    
        return OffreService.UpdateOffre(R) ;
    }
    
    
    @CrossOrigin("http://localhost:8090")
    @GetMapping("/search/{dat}/{type}/{ville}" )
    @ResponseBody

	public List<Offre> searchEvents(@PathVariable String  dat,@PathVariable String  type,@PathVariable String ville) 
	{	
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
			String startDateTime = dat;
			 
		
			 
			 
				LocalDate start1 = LocalDate.parse(startDateTime, formatter);
 				List<Offre> calendarEvents = OffreService.findByEventDateTimeBetween(start1,type,ville);
 				return calendarEvents;
	}
	
	@RequestMapping("/AllOffre")
	@ResponseBody
	public  List<Offre> getAllOffre()
	{
		   
    	List<Offre> offre=OffreService.getAll();
		return   offre ;	
	}
	
	  
	/*@CrossOrigin("http://localhost:8090")
    @PostMapping(value = "/CreateOffre",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Offre> AddOffre(
            @RequestParam("photo") MultipartFile photo,@RequestBody Offre X,String filename)
                    throws IOException {  
		 String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
	        long size = photo.getSize();
	         
	        
	         
	        Offre response = new Offre();
	       // response.setPhoto(fileName);
	        OffreService.AddOffre(X,photo,filename);
	        
		
		
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }*/
	 @GetMapping("/getIdOffre/{id}")
	 @ResponseBody
	 public Optional<Offre> getOffreById(@PathVariable(value = "id") long Id)
	         
	 {
	     return OffreService.getOffreById(Id);
	 }
	    @CrossOrigin("*")
	    @DeleteMapping(value = "/DeleteOffre/{idR}")
	    @ResponseBody
	    public void Remove (@PathVariable long idR)
	    {
	    	OffreService.DeleteOffre(idR);
	    }
	    @CrossOrigin("http://localhost:8090")
	    @PostMapping(value="/CreateOffre",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    @ResponseBody
	    public Offre create(
	            @RequestParam("file") MultipartFile multipartFile,Offre X)
	                    throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	       // long size = multipartFile.getSize();
	  
	          
	        return OffreService.AddOffre(X, multipartFile, fileName);
	    }
	    @GetMapping(path="/ImgOffre/{id}")
	    @ResponseBody
	    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") long id) throws Exception{
	        Offre off   = OffRep.findById(id).get();

	        Resource resource = new ClassPathResource("static/Files-Upload/"+off.getPhoto() ); // Assurez-vous que le chemin correspond à l'emplacement de votre image

	        if (resource.exists()) {
	            byte[] imageBytes = new byte[(int) resource.contentLength()];
	            resource.getInputStream().read(imageBytes);

	            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentType(MediaType.IMAGE_PNG).body(imageBytes);
	        } else {
	            return ResponseEntity.notFound().build();
	        }   


	    }
}
