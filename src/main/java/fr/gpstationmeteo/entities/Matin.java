package fr.gpstationmeteo.entities;


//import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Matin {

		@Id
		@Column
		@GeneratedValue
		@JsonProperty("id")
		private Long id;
	/*	
		@Column
		@JsonProperty("date")
		private OffsetDateTime date;
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
		
		@ManyToOne(targetEntity = Meteo.class)
		@JsonBackReference
		private  Meteo meteo = null;

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

		public Meteo getMeteo() {
			return meteo;
		}

		public void setMeteo(Meteo meteo) {
			this.meteo = meteo;
		}

		@Override
		public String toString() {
			return "Matin [id=" + id + ", jour=" + jour + ", temperature=" + temperature + ", commentaire="
					+ commentaire + ", icon=" + icon + ", meteo=" + meteo + "]";
		}

		
		
}
