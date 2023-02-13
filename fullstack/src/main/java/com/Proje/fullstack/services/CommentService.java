package com.Proje.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Proje.fullstack.Entities.c.Comment;
import com.Proje.fullstack.Entities.c.Post;
import com.Proje.fullstack.Entities.c.User;
import com.Proje.fullstack.Request.CommentCreateRequest;
import com.Proje.fullstack.Request.CommentUpdateRequest;
import com.Proje.fullstack.repos.CommentRepostiory;
@Service
public class CommentService {
private UserServices userServices;
private PostServices postServices;
private static CommentRepostiory commentRepostiory;
public CommentService(CommentRepostiory commentRepostiory,PostServices postServices,UserServices userServices)
{
	this.userServices=userServices;
	this.postServices=postServices;
	this.commentRepostiory=commentRepostiory;
}

public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
	// TODO Auto-generated method stub
	if(userId.isPresent()&& postId.isPresent())
	{
		return commentRepostiory.findByUserIdAndPostId(userId.get(),postId.get());
	}
	else if(userId.isPresent())
	{
return commentRepostiory.findByUserId(userId.get());
	}else if(postId.isPresent())
	{
		return commentRepostiory.findByPostId(postId.get());
	}else
	{
		return commentRepostiory.findAll();
	}
}
public Comment getOneCommentById(Long commentId) {
	return commentRepostiory.findById(commentId).orElse(null);
}
public Comment createOneComment(CommentCreateRequest request) {
	User user=userServices.getOneUser(request.getId());
	Post post = new Post();
	post=postServices.getOnePostById(request.getPostId());
	if(user!=null && post!=null) {
		Comment commentToSave=new Comment();
		commentToSave.setId(request.getId());
		commentToSave.setPost(post);
		commentToSave.setUser(user);
		commentToSave.setText(request.getText());
		return commentRepostiory.save(commentToSave);
	}else
	return null;
}

public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
	Optional<Comment> comment=(Optional<Comment>) commentRepostiory.findById(commentId);
	if(comment.isPresent()) {
		Comment commentToUpdate=comment.get();
		commentUpdateRequest.setText(commentUpdateRequest.getText());
		commentRepostiory.save(commentToUpdate);
	}else {
		return null;
	}
	
	return null;
}
@DeleteMapping("/{commentId}")
public void deleteOneComment(@PathVariable Long commentId) {
	CommentService.deleteOneCommentById(commentId);
}

private static void deleteOneCommentById(Long commentId) {
	commentRepostiory.deleteById(commentId);
}



}
