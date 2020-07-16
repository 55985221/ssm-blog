package blog.mapper;

import java.util.List;

import blog.entity.Comment;

public interface CommentMapper {
	/*
	 * 查看前五条评论
	 * */
	List<Comment> listRecentComment(Integer n);
}
