package blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.entity.Article;
import blog.entity.User;
import blog.mapper.ArticleMapper;
import blog.service.ArticleService;
import blog.service.UserService;

@Controller @RequestMapping("/user")
public class UserController {
	@Resource(name="userServiceImpl")
UserService userservice;
	@Resource(name="articleServiceImpl")
ArticleService articleservice;
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
	       String name=request.getParameter("username");
	       String pws=request.getParameter("password");
	       User user=userservice.getUserByNameOrEmail(name);
	       if(user!=null) {
	    	   if(user.getUserPass().equals(pws)) {
	    		   request.getSession().setAttribute("session_user", user);//��user�ŵ�����
	    		   List<Article> article=articleservice.listRecentArticle(5);
	    		   request.getSession().setAttribute("request_Article", article);
	    		   return "index";
	    	   }
	    	   else {
	    		   request.setAttribute("msg", "�������");
		    	   return "login";
	    	   }
	       }else {
	    	   request.setAttribute("msg", "�˺Ŵ���");
	    	   return "login";
	      }
	       
		   
		
		
}
}
