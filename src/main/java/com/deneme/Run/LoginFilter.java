package com.deneme.Run;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.deneme.Model.Personel;

@Component
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
				
		if(req.getRequestURI().equals("/Manage/") || req.getRequestURI().contains("/Manage/assets/") || req.getRequestURI().contains("/Manage/images/") || req.getRequestURI().equals("/Manage/signIn") || req.getRequestURI().equals("/Manage/unuttum") || req.getRequestURI().equals("/Manage/sifreGonder")) {
			
			chain.doFilter(request, response);
			return;
		}
		Personel personel = (Personel) req.getSession().getAttribute("activeUser");
		
		if(personel!=null) {
			
			chain.doFilter(request, response);
			return;
		}else {
			res.sendRedirect("/Manage/");
		
		}
		
		
	}
	
	@Override
	  public void destroy() {}

	  @Override
	  public void init(FilterConfig arg0) throws ServletException {}

}
