package com.Proje.fullstack.Request;

import lombok.Data;

@Data
public class CommentCreateRequest {
Long id;
Long userId;
Long postId;
String text;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public void setPostId(Long postId) {
	this.postId = postId;
}
public Long getUserId() {
	return userId;
}
public Long getPostId() {
	return postId;
}

}
