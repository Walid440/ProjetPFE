package tn.esprit.projet.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Client;
import tn.esprit.projet.entites.Offre;

 
public interface InterOffre  {

	List<Offre> getAll();

	Offre AddOffre(Offre C);

	Optional<Offre> getOffreById(long id);

	void DeleteOffre(Long id);

	Offre UpdateOffre(Offre R, Long Id);
	 public List<Offre> findByEventDateTimeBetween(LocalDate dat,String type,String ville); 
	 
}
