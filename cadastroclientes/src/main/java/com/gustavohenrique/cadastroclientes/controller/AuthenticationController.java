package com.gustavohenrique.cadastroclientes.controller;

import com.gustavohenrique.cadastroclientes.infra.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate(){
        return authenticationService.authenticate();
    }
}
