package com.bookstore.util;

import com.bookstore.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    private static String secret = "wJalrXUtnFEMIK7MDENGbPxRfiCYEXAMPLEKEY";
    private static long expiryDuration = 60 * 60 * 1000;

    public String generateJwt(User user){
        long now = System.currentTimeMillis();
        long exp = now + expiryDuration;
        Date issueAt = new Date(now);
        Date expireAt = new Date(exp);

        Claims claims = Jwts
                .claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issueAt)
                .setExpiration(expireAt);

        claims.put("userId", user.getId());
        claims.put("userName", user.getName());
        claims.put("email",user.getEmailId());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,secret.getBytes(StandardCharsets.UTF_8))
                .compact();

    }
}
