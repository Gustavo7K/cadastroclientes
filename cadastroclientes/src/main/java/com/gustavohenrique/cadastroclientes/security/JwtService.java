package com.gustavohenrique.cadastroclientes.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }
    //montando o token modificado
    public String generateToken (Authentication authentication){
        Instant now = Instant.now();
        long expiry = 3600L; //tempo de expiração

        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" ")); //pegar os escopos e colocar no token

        var claims = JwtClaimsSet.builder() //propriedades do token
                .issuer("cadastroclientes")
                .issuedAt(now) //quando foi emitido
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();

        //retornar o token modificado
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(); //pegar valor como string
    }
}
