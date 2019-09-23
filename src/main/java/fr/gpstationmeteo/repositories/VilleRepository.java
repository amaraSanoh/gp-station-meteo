/**
 * 
 */
package fr.gpstationmeteo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Ville;



/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Repository
public interface VilleRepository extends JpaRepository<Ville, String> {
	
	Ville findByNom(String nom);
	
}
