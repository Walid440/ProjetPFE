package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.projet.entites.Comment;

 
public interface InterComment  {
	
	
	
	List<Comment> getAll();

 

	Comment AddComment(Comment C);

 
	 
}
