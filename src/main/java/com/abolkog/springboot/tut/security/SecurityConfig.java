package com.abolkog.springboot.tut.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public final String[] PUBLIC_ENDPOINTS ={

            "/Api/v1/auth"
    };

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public AuthFilter authFilter (){
        return new AuthFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //1

        http // there is our configuration
                .cors().and().csrf().disable()// bec we don't need Cookies so we disable it
                .sessionManagement()
                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // beac we will use JWT so we dont need station
                       .and()
                .authorizeRequests() //Urls public and other are private
                       .antMatchers(PUBLIC_ENDPOINTS).permitAll() //this request will be public
                       .anyRequest().authenticated()// any other request have to be authenticated
                       .and()
//                   .httpBasic(); //we use http basic authentication in next tutorial we will use hidder
              //work
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
