package tn.esprit.projet.entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

 

@Entity
@Data
@Table(name = "Calendar")
 @JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize 
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Calendar implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@JsonFormat
	private String title;
	
	//@JsonIgnore
	@JsonDeserialize 
    @JsonSerialize
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime start;
	//@JsonIgnore
	@JsonDeserialize 
    @JsonSerialize
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime end;
     
    private String Color;
    
       @ManyToOne
	    @JoinColumn(name = "commande_id")
	    private Commande commande;
   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", Color=" + Color
				+ ", commande=" + commande + "]";
	}

	public Calendar(Long id, Commande commande, String title, LocalDateTime start, LocalDateTime end, String color) {
		super();
		this.id = id;	
		this.commande = commande;
		this.title = title;
		this.start = start;
		this.end = end;
		Color = color;
	
	}

	public Calendar() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}