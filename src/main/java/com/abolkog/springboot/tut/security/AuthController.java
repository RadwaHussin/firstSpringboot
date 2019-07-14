package com.abolkog.springboot.tut.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController { // with this class user can login

    @Autowired
    private TokenUtil tokenUtil;                           //inject for TokenUtil

    @Autowired
    private UserService userService;                       //inject for userService

    @Autowired
    private AuthenticationManager authenticationManager;   // we need authenticationManger

    @PostMapping(value ={"/",""})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest){ // to sign we need username and password and we will make a class contain them 'SignInRequest'

               final Authentication authentication = authenticationManager.authenticate(
                       new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
               );  //authentication 3aml ezay bzabt

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername()); //give me user information

        // now we can generate token
        String token = tokenUtil.generateToken(userDetails);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        // then return token bs in a class Jwt
        JwtResponse response = new JwtResponse(token);
        return response;





    }

}
