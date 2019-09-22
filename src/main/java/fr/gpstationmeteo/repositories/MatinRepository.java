package fr.gpstationmeteo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gpstationmeteo.entities.Matin;

@Repository
public interface MatinRepository extends JpaRepository<Matin, Long> {
	
	Matin findById(int id);
	List<Matin> findByMeteoNom(String nom);
}

