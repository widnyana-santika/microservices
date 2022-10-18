package com.idpuwid.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final int expiryTime;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final UserService userService;

    public AuthSuccessHandler(int expiryTime, UserService userService) {
        this.expiryTime = expiryTime;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = JWT.create()
                .withSubject(userService.loadUserByUsername(principal.getUsername()).getUsername())
                        .withExpiresAt(Date.from(Instant.ofEpochMilli(ZonedDateTime.now(ZoneId.systemDefault()).toInstant().toEpochMilli() + expiryTime)))
                                .sign(Algorithm.HMAC256("widnyanasantika"));
        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response.getWriter().write("{\"token\": \""+token+"\"}");
    }
}
