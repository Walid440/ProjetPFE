 package tn.esprit.projet.repositories;

import tn.esprit.projet.entites.Commande;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

 
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

  /*@Transactional
    @Modifying
    @Query("UPDATE Ferry SET isDeleted = 1 WHERE idFerry = :id")
  void DeleteFerry(Long id); 
	 */
	@Transactional
    @Query("select a from Commande a  where (a.dateDebut >=:creationDateDebut  and  a.dateDebut <= :creationDateFin)")
    
    List<Commande> findAllWithCreationDateTimeBefore( @Param("creationDateDebut") LocalDateTime creationDateDebut,@Param("creationDateFin") LocalDateTime creationDateFin);

}
