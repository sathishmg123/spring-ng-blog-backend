package com.sathish.springngblog.controller;

import com.sathish.springngblog.dto.LoginRequest;
import com.sathish.springngblog.dto.RegisterRequest;
import com.sathish.springngblog.service.AuthService;
import com.sathish.springngblog.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping ("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse Login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
