package fr.gpstationmeteo.controllers;

import javax.servlet.http.HttpServletRequest;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.services.MeteoService;
import fr.gpstationmeteo.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.repositories.VilleRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value="Station météo")
public class RechercheController {
	
	@Autowired
	private MeteoService meteoService;

    @GetMapping("meteo/recherche/{expression}")
    public List<Meteo> rechercheMeteoByJour(@PathVariable String expression) {
        return meteoService.getMeteosByJour(expression);
    }

}

