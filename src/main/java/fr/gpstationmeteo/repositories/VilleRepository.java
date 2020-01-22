/**
 * 
 */
package fr.gpstationmeteo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Ville;



/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Repository
public interface VilleRepository extends CrudRepository<Ville, String> {

}
