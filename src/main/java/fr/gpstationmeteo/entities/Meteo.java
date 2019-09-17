/**
 * 
 */
package fr.gpstationmeteo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Taleb - Yade - Sanoh
 *
 */
@Entity
public class Meteo {

	@Id
	@Column
	private String nom; 
	
	@Override
	public String toString() {
		return "Meteo [nom=" + nom + ", matin=" + matin + ", midi=" + midi + ", soir=" + soir + "]";
	}

	@Column	
	private String matin;
	
	@Column
	private String midi; 
	
	@Column
	private String soir;
	
	public Meteo() {}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMatin() {
		return matin;
	}

	public void setMatin(String matin) {
		this.matin = matin;
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

	
	


}
