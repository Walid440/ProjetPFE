package tn.esprit.projet.repositories;

import tn.esprit.projet.entites.Offre;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
 
import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {

   /* @Transactional
    @Modifying
    @Query("UPDATE Ferry SET isDeleted = 1 WHERE idFerry = :id")
  void DeleteFerry(Long id); 
	@Transactional
    @Query("select a from Ferry a  where a.departureDate >=:creationDateDebut  and  a.departureDate <= :creationDateFin ")
    
    List<Ferry> findAllWithCreationDateTimeBefore( @Param("creationDateDebut") LocalDateTime creationDate,@Param("creationDateFin") LocalDateTime creationDate2);
 */
}
