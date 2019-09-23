/**
 * 
 */
package fr.gpstationmeteo.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Entity
public class Ville {

	@Id
	@Column
	@JsonProperty("nom")
	private String nom; 
	
	@OneToMany(targetEntity = Meteo.class, mappedBy = "ville")
	@JsonManagedReference
	private  List<Meteo> meteos = null;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Meteo> getMeteos() {
		return meteos;
	}

	public void setMeteos(List<Meteo> meteos) {
		this.meteos = meteos;
	}

	@Override
	public String toString() {
		return "Ville [nom=" + nom + ", meteos=" + meteos + "]";
	}
	
	


	
}
