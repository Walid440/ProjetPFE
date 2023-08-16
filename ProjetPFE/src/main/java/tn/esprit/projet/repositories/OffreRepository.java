package tn.esprit.projet.repositories;

import tn.esprit.projet.entites.Offre;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
  
import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {

  
	@Transactional
   	@Query(value="select * from offre f where  f.date_Offre >=:dateOffre  and type=:type ", nativeQuery=true)
	 
    List<Offre> findAllWithCreationDateTimeBefore( @Param("dateOffre") LocalDate dateOffre,@Param("type") String type);
 
	
	

 
}
