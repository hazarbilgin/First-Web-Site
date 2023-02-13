package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Proje.fullstack.Entities.c.Comment;
import com.Proje.fullstack.Request.CommentCreateRequest;
import com.Proje.fullstack.Request.CommentUpdateRequest;
import com.Proje.fullstack.services.CommentService;

@RestController
@RequestMapping("/comments")
public class commentController {
private CommentService commentService;

public commentController(CommentService commentService) {
	
	this.commentService = commentService;
}
@GetMapping
public List<Comment> getAllComments(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId)
{
	return commentService.getAllCommentsWithParam(userId,postId);
}
@GetMapping("/commentId")
public 	Comment getOneComment(@PathVariable Long commentId)
{
	return commentService.getOneCommentById(commentId);
}
@PostMapping
public Comment createOneComment(@RequestBody CommentCreateRequest request){
	return commentService.createOneComment(request);
}
@PostMapping("/{commentId}")
public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest commentUpdateRequest) {
	return commentService.updateOneCommentById(commentId,commentUpdateRequest);
}

}

