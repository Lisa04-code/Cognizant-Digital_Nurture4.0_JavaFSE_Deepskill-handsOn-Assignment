package com.example.jwt.controller;

import com.example.jwt.util.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    public ResponseEntity<?> createToken(String authorization) {
        
        String base64Credentials = authorization.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);
        
        
        UserDetails userDetails = User.withUsername(values[0])
            .password(values[1])
            .roles("USER")
            .build();

        // Generate token
        String token = jwtTokenUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private static class AuthenticationResponse {
        private final String token;
        
        public AuthenticationResponse(String token) {
            this.token = token;
        }
        
        public String getToken() {
            return token;
        }
    }
}
