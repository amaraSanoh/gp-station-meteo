package fr.gpstationmeteo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Meteo;

@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {
	
	Meteo findById(int id);
	List<Meteo> findByVilleNom(String nom);
}

