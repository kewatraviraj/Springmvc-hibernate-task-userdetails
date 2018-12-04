/*package org.springmvchibernate.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@WebFilter
@PropertySource("classpath:messages.properties")
public class SessionFilter implements Filter {

	@Autowired
	private Environment environment;
	
	private ServletContext context;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession(false);

			if (session.getAttribute("user_id") != null) { // checking whether the session exists
				chain.doFilter(request, response);
			} else {
				req.setAttribute("messages", environment.getProperty("sessionexpire"));
				req.getRequestDispatcher("requestlogin").forward(request, response);
			}
		}
	}

	*//**
	 * @see Filter#init(FilterConfig)
	 *//*
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
}
*/