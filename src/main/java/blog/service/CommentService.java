package blog.service;

import java.util.List;

import blog.entity.Comment;

public interface CommentService {
	List<Comment> listRecentComment(Integer n);
}
