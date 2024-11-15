package com.bookstore.config;

import com.bookstore.dto.RequestMeta;
import com.bookstore.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    private RequestMeta requestMeta;

    public JwtInterceptor(RequestMeta requestMeta) {
        this.requestMeta = requestMeta;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String auth = request.getHeader("authorization");
        if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))){
            Claims claims = jwtUtils.verify(auth);

            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
            requestMeta.setUserName(claims.get("userName").toString());
            requestMeta.setEmailId(claims.get("email").toString());
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
