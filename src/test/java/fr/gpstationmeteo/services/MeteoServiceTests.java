package fr.gpstationmeteo.services;

import fr.gpstationmeteo.entities.Meteo;
import fr.gpstationmeteo.repositories.MeteoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeteoServiceTests {
  @Autowired
  MeteoService meteoService;

  @DataJpaTest class CreateMeteoRequest {
    private Long id;
    private String jour;
    private String temperature;
    private String commentaire;
    private String icon;
    private String ville;
  }

  @Test
  public void getMeteosByNomVilleWithVille() {
    List<Meteo> meteos = meteoService.getMeteosByNomVille("villeInexistance");
    Assert.assertTrue("la liste des météos doivent être vide", meteos.size() == 0);
  }

  @Test
  public void getMeteosByNomVilleWithExistantVille() {
    Meteo meteo= meteoService.getMeteoById(1);
    CreateMeteoRequest createMeteoRequest = new CreateMeteoRequest();

    createMeteoRequest.id = 1L;
    createMeteoRequest.jour = "lundi";
    createMeteoRequest.temperature = "12";
    createMeteoRequest.commentaire = "pluie";
    createMeteoRequest.icon = "fas fa-cloud-showers-heavy";
    createMeteoRequest.ville = "Metz";

    Assert.assertEquals("les meteos devront avoir le meme nom de ville",meteo.getVille(),createMeteoRequest.ville);
  }
  @Test
  public void getMeteosByJourNonExistantTest(){
    List<Meteo> meteos = meteoService.getMeteosByJour("jourInexistant");
    assert meteos.size() == 0:"la liste des météos doivent être vide";
    Assert.assertTrue("la liste des météos doivent être vide", meteos.size() == 0);

  }
  @Test
  public void getMeteosByJourExistantTest(){
    List<Meteo> meteos = meteoService.getMeteosByJour("lundi");
    for (Meteo meteo:meteos) {
      Assert.assertTrue("la liste des météos ne doivent contenir que des lundi", meteo.getJour().equals("lundi"));
    }
  }



}
