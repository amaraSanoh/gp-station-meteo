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
public class Meteo {

	@Id
	@Column
	@JsonProperty("nom")
	private String nom; 
	
	@OneToMany(targetEntity = Matin.class, mappedBy = "meteo")
	@JsonManagedReference
	private  List<Matin> matins = null;
	
	@Column
	@JsonProperty("midi")
	private String midi; 
	
	@Column
	@JsonProperty("soir")
	private String soir;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Matin> getMatins() {
		return matins;
	}
	
	public void addMatin(Matin matin) {
		this.matins.add(matin);
		matin.setMeteo(this);
	}

	public void setMatins(List<Matin> matins) {
		this.matins = matins;
	}

	public String getMidi() {
		return midi;
	}

	public void setMidi(String midi) {
		this.midi = midi;
	}

	public String getSoir() {
		return soir;
	}

	public void setSoir(String soir) {
		this.soir = soir;
	}

	@Override
	public String toString() {
		return "Meteo [nom=" + nom + ", matins=" + matins + ", midi=" + midi + ", soir=" + soir + "]";
	}


	
}
