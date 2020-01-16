/**
 * 
 */
package fr.gpstationmeteo.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.gpstationmeteo.services.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.repositories.VilleRepository;
import io.swagger.annotations.Api;

/**
 * @author Taleb - Yade - Amara
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="Station météo")
public class MeteosControllers {

    @Autowired
    private MeteoService meteoService;

    @GetMapping("/meteo/{id}")
    public Meteo meteo(@PathVariable long id)
    {
        return meteoService.getMeteoById(id);
    }

    @GetMapping("/meteos")
    public List<Meteo> meteos()
    {
        return meteoService.meteos();
    }

    @PostMapping("/ajout/meteo")
    public Meteo ajoutMeteo(@RequestBody Meteo meteo)
    {
        meteoService.saveOrUpdate(meteo);
        return meteo;
    }

    @DeleteMapping("meteo/suppression/{id}")
    public void deleteMeteo(@PathVariable long id)
    {
        meteoService.deleteMeteo(id);
    }



}
