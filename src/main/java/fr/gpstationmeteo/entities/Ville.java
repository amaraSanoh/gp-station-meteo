package fr.gpstationmeteo.entities;



import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * la classe ville.
 * @author Taleb - Yade - Sanoh
 */
@Entity
public class Ville {

  @Id
  @Column
  @JsonProperty("nom")
  private String nom;

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "ville", cascade = CascadeType.ALL, orphanRemoval = true)
  private  Collection<Meteo> meteos;

  public String getNom() {
    return nom;
	}

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Collection<Meteo> getMeteos() {
    return meteos;
  }

  public void setMeteos(Collection<Meteo> meteos) {
    this.meteos = meteos;
  }

  @Override
  public String toString() {
    return "Ville [nom=" + nom + ", meteos=" + meteos.toString() + "]";
  }

}
