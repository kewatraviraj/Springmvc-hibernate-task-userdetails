package org.springmvchibernate.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter
public class NoCacheFilter implements Filter{

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
    	
    	if(!(res instanceof HttpServletResponse))
	    {
	        throw new ServletException("non-HTTP response");
	    }
	 
	 	HttpServletResponse response = (HttpServletResponse) res;

	 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	 	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	 	response.setDateHeader("Expires", 0); // Proxies.

        chain.doFilter(req, res);
    }
    
    /*if (res instanceof HttpServletResponse && req instanceof HttpServletRequest) {
	
	HttpSession session = ((HttpServletRequest) req).getSession(false);
	
    if (session != null) {
        if(session.getAttribute("user_id") != null) {
        	HttpServletResponse response=(HttpServletResponse)res;
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", -1);
        }
        chain.doFilter(req, res);
    }else {	        	
    	chain.doFilter(req, res);
    }
	}*/
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}

