package fr.gpstationmeteo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Meteo {

  @Id
  @Column
  @JsonProperty("id")
  private Long id;
  /*
  @Column
  @JsonProperty("date")
  */
		
  @Column
  @JsonProperty("jour")
  private String jour;

  @Column
  @JsonProperty("temperature")
  private String temperature;

  @Column
  @JsonProperty("commentaire")
  private String commentaire;

  @Column
  @JsonProperty("icon")
  private String icon;

  @Column
  @JsonProperty("ville")
  private String ville;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getJour() {
    return jour;
  }

  public void setJour(String jour) {
    this.jour = jour;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public String getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(String commentaire) {
    this.commentaire = commentaire;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  @Override
  public String toString() {
    return "Meteo [id=" + id + ", jour=" + jour + ", temperature=" + temperature
      + ", commentaire=" + commentaire + ", icon="
      + icon + ", ville=" + ville + "]";
  }

}
