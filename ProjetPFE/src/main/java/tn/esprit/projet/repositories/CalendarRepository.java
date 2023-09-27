package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.projet.entites.Calendar;

import java.util.List;
@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    @Query(value ="select * from Calendar m where m.user_id=:id  ", nativeQuery = true)

    List<Calendar> findByUser(Long id) ;
    @Query(value ="select * from Calendar m where m.name=:name  ", nativeQuery = true)

    List<Calendar> findByName(String  name) ;
}
