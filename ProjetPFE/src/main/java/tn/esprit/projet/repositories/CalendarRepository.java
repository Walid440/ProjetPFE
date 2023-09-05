package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.projet.entites.Calendar;

 
 

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

}
