package com.gustavohenrique.cadastroclientes.controller;

import com.gustavohenrique.cadastroclientes.model.Users;
import com.gustavohenrique.cadastroclientes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<List<Users>> registerUser(@Valid @RequestBody Users users) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUsers(users));
    }
}
