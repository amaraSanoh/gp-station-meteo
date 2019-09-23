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
public class GetMeteosControllers {
	
	@Autowired
	private MeteoRepository meteoRepo;
	@Autowired
	private VilleRepository villeRepo;
	
	@GetMapping("/ville/{nom}")
	public Ville ville(HttpServletRequest request, @PathVariable String nom) 
	{ 
		return villeRepo.findByNom(nom);
	}
	
	@GetMapping("/ville/{nom}/meteos")
	public List<Meteo> meteosByVille(HttpServletRequest request, @PathVariable String nom) 
	{
		return meteoRepo.findByVilleNom(nom);
	}
	
	@GetMapping("/ville/{nom}/meteo/{jour}")
	public Meteo meteoByJour(HttpServletRequest request, @PathVariable String nom, @PathVariable String jour) 
	{
		return meteoRepo.findMeteoByJour(nom, jour);
	}
}
