package com.bookstore.util;

import com.bookstore.common.AccessDeniedException;
import com.bookstore.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "wJalrXUtnFEMIK7MDENGbPxRfiCYEXAMPLEKEY";
    private static final long expiryDuration = 60 * 60 * 1000;

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

    public Claims verify(String authorization) throws AccessDeniedException {

        try {
//            Jwts.parser().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(authorization);

            Claims claims = Jwts.parser()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(authorization)
                    .getBody();
//            System.out.println(claims.get("userName"));
            return claims;
        } catch (Exception ex) {
            throw new AccessDeniedException("Access Denied");
        }
    }
}
