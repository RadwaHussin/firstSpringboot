package com.abolkog.springboot.tut.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component // to be able to use it as autowired
public class TokenUtil { // this class for generating token


    private final String Cliams_Subject = "sub"; // private attribute can access within the class only while public can access inside or outside the class.
    private final String Claims_CREATED = "created";

    @Value("${auth.expiration}")
    private Long TOKEN_VALIDATY = 604800L ; // ti kone when the token will be expired ex the token expired after 7 dayes

    @Value("${auth.secreate}")
    private String TOKEN_SECREATE ;

    public String generateToken(UserDetails userDetails){
        // to generate token we need to send claim , expiration , sign , compact to y7awl token to string

        Map<String, Object> claims = new HashMap<>();
          claims.put(Cliams_Subject,userDetails.getUsername());  //  claims.put("sub",userDetails.getUsername());
          claims.put(Claims_CREATED,new Date());  //  claims.put("created ", new Date());

        return Jwts.builder()   // https://jwt.io/
           .setClaims(claims)   // the claim
           .setExpiration(generateExpirationdate()) //expiration
           .signWith(SignatureAlgorithm.HS512, TOKEN_SECREATE) // make sign for token
           .compact();
    }
    ///***
    //v9

    public String getUserNameFromToken(String token){
        try {
             Claims claims = getClaims(token);
             return claims.getSubject();
        } catch (Exception ex){
            return null;


        }
    }

    private Date generateExpirationdate(){
        return new Date(System.currentTimeMillis() + TOKEN_VALIDATY *1000);

    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        // check username in DB = user in Jwt website     check expiry date
          return (username.equals(userDetails.getUsername()) && !istokenExpired(token));

    }

    private boolean istokenExpired(String token) { // this function tell us is token is expired or not
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

     private Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(TOKEN_SECREATE) // to return the claims
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            claims = null;
        }
         return claims ;
    }
}
