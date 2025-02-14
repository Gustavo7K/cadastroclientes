package com.gustavohenrique.cadastroclientes.infra;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken (Authentication authentication){
        return null;  //"Return" temporario, pois tive que parar de programar nesse momento.
    }
}
