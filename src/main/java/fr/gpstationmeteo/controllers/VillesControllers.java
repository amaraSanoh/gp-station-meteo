package fr.gpstationmeteo.controllers;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.services.MeteoService;
import fr.gpstationmeteo.services.VilleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Taleb - Yade - Amara
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="station de chaque villes")

public class VillesControllers {

    @Autowired
    VilleService villeService;

    @GetMapping("/villes")
    public List<Ville> villes()
    {
        return villeService.villes();
    }

    @GetMapping("/ville/{nom}")
    public Ville ville(@PathVariable String nom)
    {
        return villeService.getVilleByNom(nom);
    }

    @GetMapping("/ville/{nom}/meteos")
    public List<Meteo> meteosByVille(@PathVariable String nom)
    {
        return villeService.getMeteosByNomVille(nom);
    }

    @PostMapping("villes/ajout")
    public Ville ajoutVille(@RequestBody Ville ville){
        villeService.saveOrUpdate(ville);
        return ville;
    }

    @DeleteMapping("ville/suppression/{nom}")
    public void deleteVille(@PathVariable String nom){
        villeService.deleteVille(nom);
    }

}
