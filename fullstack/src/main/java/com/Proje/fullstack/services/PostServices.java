package com.Proje.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Proje.fullstack.Entities.c.Post;
import com.Proje.fullstack.Entities.c.User;
import com.Proje.fullstack.Request.PostCreateRequest;
import com.Proje.fullstack.Request.PostUpdateRequest;
import com.Proje.fullstack.repos.PostRepository;

@Service
public class PostServices {
	private UserServices useService;
 PostRepository postRepository;

public PostServices(PostRepository postRepository,UserServices useService) {
	this.useService=useService;
	this.postRepository = postRepository;
}

public Post getOnePostById(Long postId) {
	
		return postRepository.findById(postId).orElse(null);
	}

public List<Post> getAllPosts(Optional<Long> userId) {
	if(userId.isPresent())
		return PostRepository.findByUserId(userId.get());
	return postRepository.findAll();
	
}

public Post createOnePost(PostCreateRequest newPostRequest) {
	User user=useService.getOneUser(newPostRequest.getUserId());
	if(user==null) {
		return null;
	}
	Post toSave=new Post();
	toSave.setId(newPostRequest.getId());
	toSave.setText(newPostRequest.getText());
	toSave.setText(newPostRequest.getTitle());
	toSave.setUser(user);
	return postRepository.save(newPostRequest);
}

public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
	Optional<Post> post=postRepository.findById(postId);
	if(post.isPresent())
	{
		Post toUpdate=post.get();
		toUpdate.setText(updatePost.getText());
		toUpdate.setTitle(updatePost.getTitle());
		postRepository.save(toUpdate);
		return toUpdate;
	}
	return null;
}

public void deleteOnePostById(Long postId) {
	postRepository.deleteById(postId);
	
}



}
