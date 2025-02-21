package com.gustavohenrique.cadastroclientes.controller;

import com.gustavohenrique.cadastroclientes.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
}
