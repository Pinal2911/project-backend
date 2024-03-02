package com.projectbackend.projectbackend.security;

import com.projectbackend.projectbackend.exception.TnpApiException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JWTTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    public String generateToken(Authentication authentication){
        String username=authentication.getName();
        System.out.println(username);
        Date currDate=new Date();
        Date expireDate=new Date(currDate.getTime()+jwtExpirationDate);
        String token= Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();
        System.out.println(token);
        return token;
    }


    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;
        }catch (MalformedJwtException malformedJwtException){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"invaid jwt token");
        }catch (ExpiredJwtException expiredJwtException){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"expired jwt token");
        }catch (UnsupportedJwtException unsupportedJwtException){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"unsupported JWT token");
        }catch (IllegalArgumentException illegalArgumentException){
            throw new TnpApiException(HttpStatus.BAD_REQUEST,"Jwt claims string is empty");
        }

    }

}
