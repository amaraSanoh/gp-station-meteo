/**
 * 
 */
package fr.gpstationmeteo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.repositories.MeteoRepository;


/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Controller
public class MeteosController {
	
	@Autowired
	private MeteoRepository meteoRepo;
	
	
	/**
	 * 
	 * @param request
	 * @return La liste des villes de France et leurs météos
	 */
	@GetMapping("/gestionMeteos")
	public String gestionMeteos(HttpServletRequest request, ModelMap model) {
		
		Iterable<Meteo> meteos = meteoRepo.findAll();
        
        //MappingJacksonValue jacksonMeteos = new MappingJacksonValue(meteos);
        
        model.put("jacksonMeteos", meteos);
        
		return "Meteos/GestionMeteos";
	}
}
