package fr.gpstationmeteo.services;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.repositories.MeteoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeteoService {

  @Autowired
  MeteoRepository meteoRepository;
  /**
   * Récuperer toutes les meteos.
   * @return liste des meteos.
   **/

  public List<Meteo> meteos() {
    List<Meteo> meteos = new ArrayList<>();
    meteoRepository.findAll().forEach(meteo -> meteos.add(meteo));
    return meteos;
  }

  /**
  * Récuperer une entité d une meteo.
  * @param id  de la meteo.
  * @return une entite de type meteo.
  */
  public Meteo getMeteoById(long id) {
    Optional<Meteo> optionalMeteo = meteoRepository.findById(id);
    if (optionalMeteo.isPresent()) {
      return optionalMeteo.get();
    }
    return null;
  }

  /**
   * Sauvegarder ou mettre à jour une meteo.
   * @param meteo une entite de type meteo.
   */
  public void saveOrUpdate(Meteo meteo) {
    meteoRepository.save(meteo);
  }

  /**
   * supprimer une meteo.
   * @param id long: l´identifiant de la entité.
   */
  public void deleteMeteo(long id) {
    meteoRepository.deleteById(id);
  }

  public List<Meteo> getMeteosByNomVille(String nom) {
    return meteoRepository.findMeteoByVille(nom);
  }

  public List<Meteo> getMeteosByJour(String expression) {
    return meteoRepository.findMeteoByJour(expression);
  }
}
