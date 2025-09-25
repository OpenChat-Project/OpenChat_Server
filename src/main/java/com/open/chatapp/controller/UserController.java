package com.open.chatapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.chatapp.dto.UserDTO;
import com.open.chatapp.dto.response.JwtResponse;
import com.open.chatapp.util.JwtProvider;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserId(),
                        loginRequest.getUserPw()
                )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(loginRequest.getUserId());
            
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }
	
}
