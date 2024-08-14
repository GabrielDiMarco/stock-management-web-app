package com.stock.resources;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	    HttpServletResponse res = (HttpServletResponse) response;
	    HttpServletRequest req = (HttpServletRequest) request;

	    res.addHeader("Access-Control-Allow-Origin", "*");
	    res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
	    res.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
	    res.addHeader("Access-Control-Allow-Credentials", "true");

	    chain.doFilter(request, res);
	  }

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

}
