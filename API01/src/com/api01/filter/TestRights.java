package com.api01.filter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestRights implements HandlerInterceptor  {
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {    	
	    HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();	
		String url = httpRequest.getRequestURL().toString();
		Integer isAdmin = (Integer)session.getAttribute("admin");
		//not connected		
		if(isAdmin != null){				
			if(url.contains("/admin") && isAdmin!=1){
				System.out.println(isAdmin == 1);
				//Un authorized page ?
				System.out.println("not admin");
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
				return false;
			} 
			if((url.contains("/register") || url.contains("/login")) && isAdmin != 0){
				//Un authorized page ? 
				System.out.println("registered allready");
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
				return false;
			}
		}else{
			if(url.contains("/home") || url.contains("/login") || url.contains("/register")){
				System.out.println("not connected but url is k");
				return true;				
			}else{
				System.out.println("not connected");
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
				return false;
			}
		}						
		return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception { 
    }
     
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {        
    }
}
