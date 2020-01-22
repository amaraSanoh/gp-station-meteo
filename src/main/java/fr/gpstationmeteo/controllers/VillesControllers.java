package fr.gpstationmeteo.controllers;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.entities.Ville;

import fr.gpstationmeteo.services.VilleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.opencsv.ICSVWriter.DEFAULT_QUOTE_CHARACTER;

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


    @GetMapping("/export-villes")
    public void exportCSV(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String filename = "villes.csv";

        response.setContentType("text/csv");
        response.setHeader( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
        StatefulBeanToCsv<Ville> writer = new StatefulBeanToCsvBuilder<Ville>(response.getWriter())
                .withQuotechar(DEFAULT_QUOTE_CHARACTER)
                .withSeparator(';')
                .withOrderedResults(false)
                .build();

        writer.write(villeService.villes());
    }

}
