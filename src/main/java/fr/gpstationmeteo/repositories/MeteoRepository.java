package fr.gpstationmeteo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Meteo;

@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {
	
	Meteo findById(int id);
	List<Meteo> findByVilleNom(String nom);
	
	@Query(value = "SELECT * FROM meteo join ville on ville.nom = meteo.ville_nom WHERE meteo.jour = ?2 and ville.nom = ?1", 
			  nativeQuery = true)
	Meteo findMeteoByJour( String nom, String jour); 
}

