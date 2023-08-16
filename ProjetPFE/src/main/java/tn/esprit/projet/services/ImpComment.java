package tn.esprit.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.projet.entites.Comment;
import tn.esprit.projet.repositories.CommentRepository;
@Service
public class ImpComment implements InterComment {
	
	
	 @Autowired
	    private CommentRepository CommentRep;

	  @Override
	    public List<Comment> getAll() {
	        return (List<Comment>) CommentRep.findAll();
	    }
	 
 
 
	@Override
	public Comment AddComment(Comment  C) {
		// TODO Auto-generated method stub
		Comment com=CommentRep.save(C);
		return com;
	}
	 
	

}
