package fr.gpstationmeteo.repositories;


import fr.gpstationmeteo.entities.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Repository
public interface VilleRepository extends CrudRepository<Ville, String> {

}
