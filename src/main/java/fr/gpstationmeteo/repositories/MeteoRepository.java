package fr.gpstationmeteo.repositories;

import fr.gpstationmeteo.entities.Meteo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {
	
  @Query(value = "SELECT * FROM meteo", nativeQuery = true)
  List<Meteo> findAll();

  @Query(value = "SELECT * FROM meteo join ville on ville.nom = meteo.ville_nom "
       +	"WHERE meteo.jour LIKE %?1%", nativeQuery = true)
  List<Meteo> findMeteoByJour(String jour);

  @Query(value = "SELECT * FROM meteo WHERE meteo.ville_nom = ?1",nativeQuery = true)
  List<Meteo> findMeteoByVille(String nom);
}

