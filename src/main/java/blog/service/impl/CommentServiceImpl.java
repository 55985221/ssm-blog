package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Comment;
import blog.mapper.CommentMapper;
import blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
@Resource
CommentMapper commentmapper;
public List<Comment> listRecentComment(Integer n) {
 return commentmapper.listRecentComment(n);
}
}
