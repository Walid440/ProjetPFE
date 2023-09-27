package tn.esprit.projet.entites;
 
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    
    private String username;
    private String commentText;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateJour ;
    
    @Enumerated(EnumType.STRING)
    private Rating rating; // You can use an integer to represent the rating
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	 
	public Date getDateJour() {
		return dateJour;
	}
	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
 
	@Override
	public String toString() {
		return "Comment [id=" + id + ", username=" + username + ", commentText=" + commentText + ", dateJour="
				+ dateJour + ", rating=" + rating + "]";
	}
	public Comment(Long id, String username, String commentText, Date dateJour, Rating rating) {
		super();
		this.id = id;
		this.username = username;
		this.commentText = commentText;
		this.dateJour = dateJour;
		this.rating = rating;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
  
}
