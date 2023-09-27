 package tn.esprit.projet.services;


import java.time.LocalDateTime;
import java.util.EventListener;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Calendar;
import tn.esprit.projet.entites.Commande;
import tn.esprit.projet.repositories.CalendarRepository;

 

@Service
public class CalendarService {
	
	@Autowired
	private CalendarRepository calendarRepository;
 
 
	public Calendar retrieveCalendar(long id) {
		Optional<Calendar> calendar = calendarRepository.findById(id);

		if (!calendar.isPresent())
		{
			return null;
		}
		return calendar.get();
	}
	public List<Calendar> retrieveCalendarByName(String name) {



		return calendarRepository.findByName(name);
	}

	  public List<Calendar> getAllCal() {
	        return (List<Calendar>) calendarRepository.findAll();
	    }
	 
	
 
 

	public Calendar AddCalendar(Calendar calendar) {
		 return calendarRepository.save(calendar);
	}
	
	public void deleteCalendar(Calendar calendar)
	{
		calendarRepository.delete(calendar);
	}
	
	 
}
