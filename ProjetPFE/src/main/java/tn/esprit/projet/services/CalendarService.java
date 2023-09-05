package tn.esprit.projet.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.entites.Produit;
import tn.esprit.projet.repositories.CalendarRepository;
import tn.esprit.projet.repositories.CommandeRepository;
import tn.esprit.projet.repositories.ProduitRepository;

 

 
 

@Service
public class CalendarService {
 
	@Autowired
	private CalendarRepository calendarRepository;

	@Autowired
	private ProduitRepository VoitureRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	
	
	public Calendar retrieveCalendar(long id) {
		Optional<Calendar> calendar = calendarRepository.findById(id);

		if (!calendar.isPresent())
		{
			return null;
		}
		return calendar.get();
	}

	public List<Calendar> retrieveAllCalendars() {
		return calendarRepository.findAll();
	}
	public List<Produit> retrieveAllEvents() {
		return VoitureRepository.findAll();
	}
	
	 
	public Calendar addCalendar(Calendar calendar)
	{
		return calendarRepository.saveAndFlush(calendar);
	}
	
	public Calendar updateCalendar(Calendar calendar) {
		Calendar searchedCalendar = retrieveCalendar(calendar.getId());
		if(searchedCalendar != null)
		{
			searchedCalendar.setName(calendar.getName());
			//searchedCalendar.setUser(calendar.getUser());
			return calendarRepository.saveAndFlush(calendar);
		}
		else return null;			
	}
	
	public void deleteCalendar(Calendar calendar)
	{
		calendarRepository.delete(calendar);
	}
	
	
}
