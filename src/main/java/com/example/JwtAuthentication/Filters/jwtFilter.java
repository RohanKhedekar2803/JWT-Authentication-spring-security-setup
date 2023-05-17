package com.example.JwtAuthentication.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.JwtAuthentication.Services.CustomUserDetails;
import com.example.JwtAuthentication.Services.CustomUserDetailsService;
import com.example.JwtAuthentication.Services.jwtUtils;

@Component
public class jwtFilter extends OncePerRequestFilter {

	@Autowired
	private jwtUtils jwtutils;
	
	@Autowired
	private CustomUserDetailsService userdetailservices;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// extract auth header
		
		String authorizationheader =request.getHeader("Authorization");
		
		String token =null;
		String Username=null;
		if(authorizationheader!=null && authorizationheader.startsWith("Bearer ")) {
			token=authorizationheader.substring(7);
			Username=jwtutils.extractUsername(token);
		}
		
		if(Username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userdetails =	userdetailservices.loadUserByUsername(Username);
			
			   if (jwtutils.validateToken(token, userdetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }		
		}
		  filterChain.doFilter(request,response);
		
	}

}
