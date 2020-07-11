package blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.entity.User;
import blog.service.UserService;

@Controller @RequestMapping("/user")
public class UserController {
	@Resource(name="userServiceImpl")
UserService userservice;
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
	       String name=request.getParameter("username");
	       String pws=request.getParameter("password");
	       User user=userservice.getUserByNameOrEmail(name);
	       System.out.println(name);
	       if(user!=null) {
	    	   if(user.getUserPass().equals(pws)) {
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
