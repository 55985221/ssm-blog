package blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import blog.mapper.ArticleMapper;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import blog.service.impl.CommentServiceImpl;

@Controller @RequestMapping("/user")
public class UserController {
	@Resource(name="userServiceImpl")
UserService userservice;
	@Resource(name="articleServiceImpl")
ArticleService articleservice;
	@Resource(name="commentServiceImpl")
CommentService commentservice;
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
	       String name=request.getParameter("username");
	       String pws=request.getParameter("password");
	       User user=userservice.getUserByNameOrEmail(name);
	      
	       if(user!=null) {
	    	   if(user.getUserPass().equals(pws)) {
	    		   request.getSession().setAttribute("session_user", user);//∞—user∑≈µΩ”Ú÷–
	    		   List<Article> article=articleservice.listRecentArticle(5);
	    		   List<Comment> comment=commentservice.listRecentComment(5);
	    		   request.getSession().setAttribute("request_Article", article);
	    		   request.getSession().setAttribute("request_Comment", comment);
	    		   return "index";
	    	   }
	    	   else {
	    		   request.setAttribute("msg", "√‹¬Î¥ÌŒÛ");
		    	   return "login";
	    	   }
	       }else {
	    	   request.setAttribute("msg", "’À∫≈¥ÌŒÛ");
	    	   return "login";
	      }
	       
		   
		
		
}
}
