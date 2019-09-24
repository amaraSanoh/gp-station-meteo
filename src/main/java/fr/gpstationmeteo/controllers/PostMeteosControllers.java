package fr.gpstationmeteo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gpstationmeteo.entities.Ville;
import fr.gpstationmeteo.repositories.MeteoRepository;
import fr.gpstationmeteo.repositories.VilleRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value="Station météo")
public class PostMeteosControllers {
	
	@Autowired
	private MeteoRepository meteoRepo;
	@Autowired
	private VilleRepository villeRepo;
	
	@PostMapping("/ajout/ville")
	public Ville ajoutVille(HttpServletRequest request) {
		return null; 
	}
}
