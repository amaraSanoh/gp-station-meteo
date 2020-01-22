package fr.gpstationmeteo.controllers;


import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.services.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

