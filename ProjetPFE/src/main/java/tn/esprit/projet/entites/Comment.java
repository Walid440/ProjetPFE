package tn.esprit.projet.entites;

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
    private int rating; // You can use an integer to represent the rating
    
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

	public Comment(Long id, String username, String commentText, int rating) {
		super();
		this.id = id;
		this.username = username;
		this.commentText = commentText;
		this.rating = rating;
	}
	

	@Override
	public String toString() {
		return "Comment [id=" + id + ", username=" + username + ", commentText=" + commentText + ", rating=" + rating
				+ "]";
	}

	public Comment() {
		super();
 	}
    
 
}
