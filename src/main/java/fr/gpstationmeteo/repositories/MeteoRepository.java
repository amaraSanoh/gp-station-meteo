/**
 * 
 */
package fr.gpstationmeteo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Meteo;



/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Repository
public interface MeteoRepository extends JpaRepository<Meteo, String> {
	
	Meteo findByNom(String nom);
	
}
