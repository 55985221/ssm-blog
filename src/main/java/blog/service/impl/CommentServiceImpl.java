package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Comment;
import blog.mapper.ArticleMapper;
import blog.mapper.CommentMapper;
import blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
@Resource
CommentMapper commentmapper;
@Resource
ArticleMapper articlemapper;
public List<Comment> listRecentComment(Integer n) {
	List<Comment> commentlist = commentmapper.listRecentComment(n);
	for(Comment comment:commentlist) {
		comment.setArticle(articlemapper.getArticleByid(comment.getCommentArticleId()));
	}
	return commentlist;
}
}
