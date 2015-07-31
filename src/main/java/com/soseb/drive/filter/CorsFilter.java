package com.soseb.drive.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain arg2)
			throws ServletException, IOException {

		httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept");

	}
}
