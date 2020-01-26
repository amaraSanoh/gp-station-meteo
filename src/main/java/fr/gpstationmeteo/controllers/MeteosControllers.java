package fr.gpstationmeteo.controllers;

import static com.opencsv.ICSVWriter.NO_QUOTE_CHARACTER;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.services.MeteoService;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


/**
 * @author Taleb - Yade - Amara
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "Station météo")
public class MeteosControllers {

  @Autowired
  private MeteoService meteoService;

  @GetMapping("/meteo/{id}")
  public Meteo meteo(@PathVariable long id) {
    return meteoService.getMeteoById(id);
  }

  @GetMapping("/meteos")
  public List<Meteo> meteos() {
    return meteoService.meteos();
  }

  @PostMapping("/ajout/meteo")
  public Meteo ajoutMeteo(@RequestBody Meteo meteo) {
    meteoService.saveOrUpdate(meteo);
    return meteo;
  }

  @DeleteMapping("meteo/suppression/{id}")
  public void deleteMeteo(@PathVariable long id) {
    meteoService.deleteMeteo(id);
  }

  /**
   * methode export.
   * @param response le fichier CSV.
   * @throws IOException a.
   * @throws CsvDataTypeMismatchException exception.
   * @throws CsvRequiredFieldEmptyException exception.
   */
  @GetMapping("/export-meteos")
  public void exportCsv(HttpServletResponse response)
          throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
    String filename = "meteos.csv";
    response.setContentType("text/csv");
    response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + filename + "\"");
    StatefulBeanToCsv<Meteo> writer = new StatefulBeanToCsvBuilder<Meteo>(response.getWriter())
                .withQuotechar(NO_QUOTE_CHARACTER)
                .withSeparator(';')
                .withOrderedResults(false)
                .build();
    writer.write(meteoService.meteos());
  }
}
