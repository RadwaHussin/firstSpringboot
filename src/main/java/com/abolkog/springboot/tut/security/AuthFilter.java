package com.abolkog.springboot.tut.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter { // call only one time
    // to konw header place
    @Value("${auth.header}")
    private String TOKEN_HEADER;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // step1: we need to take token from header
        final String header = request.getHeader(TOKEN_HEADER);  //hat el header   w hat el username mn el token
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        if (header != null && securityContext.getAuthentication() ==null) {

            String token = header.substring(" Bearer".length());
            String username = tokenUtil.getUserNameFromToken(token); // hat el username mn token
                                 // if not found
            if(username !=null) {
                UserDetails userDetails = userService.loadUserByUsername(username);
        // step 2: make sure it is valid
                if (tokenUtil.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                    authentication.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request,response);
    }
}
