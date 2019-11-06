package fr.gpstationmeteo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.repositories.VilleRepository;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("/api")
@Api(value="Station météo")
public class RechercheController {
	
	@Autowired
	private MeteoRepository meteoRepo;
	@Autowired
	private VilleRepository villeRepo;
	
	@GetMapping("ville/{ville}/recherche/{expression}")
	public Ville rechercheVille(HttpServletRequest request) {
		return null; 
	}
	
}
