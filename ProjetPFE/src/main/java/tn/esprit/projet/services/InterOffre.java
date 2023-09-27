package tn.esprit.projet.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Offre;

 
public interface InterOffre  {

	List<Offre> getAll();
	public Offre AddOffre(Offre C,MultipartFile file,String photo) throws IOException;

	Optional<Offre> getOffreById(long id);

	void DeleteOffre(Long id);

	Offre UpdateOffre(Offre R);
	 public List<Offre> findByEventDateTimeBetween(LocalDate dat,String type,String ville); 
	 
}
