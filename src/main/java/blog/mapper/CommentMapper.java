package blog.mapper;

import java.util.List;

import blog.entity.Comment;

public interface CommentMapper {
	/*
	 * �鿴ǰ��������
	 * */
	List<Comment> listRecentComment(Integer n);
}
