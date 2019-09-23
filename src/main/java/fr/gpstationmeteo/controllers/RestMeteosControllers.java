/**
 * 
 */
package fr.gpstationmeteo.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gpstationmeteo.entities.Matin;
import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.repositories.MatinRepository;
import fr.gpstationmeteo.repositories.MeteoRepository;
import io.swagger.annotations.Api;

/**
 * @author Taleb - Yade - Amara
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="Station météo")
public class RestMeteosControllers {
	
	@Autowired
	private MeteoRepository meteoRepo;
	@Autowired
	private MatinRepository matinRepo;
	
	@GetMapping("/meteo/{nom}")
	public Meteo getMeteo(HttpServletRequest request, @PathVariable String nom) 
	{ 
		return meteoRepo.findByNom(nom);
	}
	
	@GetMapping("/meteo/{nom}/matins")
	public List<Matin> getMatins(HttpServletRequest request, @PathVariable String nom) 
	{
		return matinRepo.findByMeteoNom(nom);
	}
}
