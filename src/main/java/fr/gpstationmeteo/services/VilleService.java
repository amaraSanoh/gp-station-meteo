package fr.gpstationmeteo.services;


import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.repositories.VilleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
  @Autowired
  VilleRepository villeRepository;
  @Autowired
  MeteoRepository meteoRepository;

  /**
   *  Récuperer toutes les villes.
   * @return liste des villes.
   **/
  public List<Ville> villes() {
    List<Ville> villes = new ArrayList<>();
    villeRepository.findAll().forEach(ville -> villes.add(ville));
    return villes;
  }

  /**
   * Récuperer une entité d une ville.
   * @param nom nom de la ville (son identifiant).
   * @return une entite de type ville.
   */
  public Ville getVilleByNom(String nom) {
    Optional<Ville> ville = villeRepository.findById(nom);
    if (ville.isPresent()) {
      return ville.get();
    }
    return null;
  }

  /**
   * Sauvegarder ou mettre à jour une ville.
   * @param ville une entite de type ville.
   */
  public void saveOrUpdate(Ville ville) {
    villeRepository.save(ville);
  }

  /**
   * supprimer une ville.
   * @param nom String: l´identifiant de la entité.
   */
  public void deleteVille(String nom) {
    villeRepository.deleteById(nom);
  }

  public List<Meteo> getMeteosByNomVille(String nom) {
    return meteoRepository.findMeteoByVille(nom);
  }
}
