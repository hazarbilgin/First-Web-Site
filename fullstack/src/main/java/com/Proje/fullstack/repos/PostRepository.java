package com.Proje.fullstack.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Proje.fullstack.Entities.c.Post;
import com.Proje.fullstack.Request.PostCreateRequest;




public interface PostRepository extends JpaRepository<Post,Long>{

	static List<Post> findByUserId(Long long1) {
		// TODO Auto-generated method stub
		return null;
	}

	Post save(PostCreateRequest newPostRequest);

	


}
