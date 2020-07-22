package blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import blog.entity.User;

public class SessionFilter implements Filter{
public void destroy() {
}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request1=(HttpServletRequest) request;
		User user=(User) request1.getSession().getAttribute("session_user");
		String url=request1.getRequestURI();
		if(url.endsWith("login")||url.endsWith("login.jsp")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".png")) {
			System.out.println(url);
			chain.doFilter(request, response);
		}
		if(user!=null) {
			chain.doFilter(request, response);
			}else {
				System.out.println("������ ");
				request1.getRequestDispatcher("/jsp/login.jsp").forward(request1, response);
				}
			}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
