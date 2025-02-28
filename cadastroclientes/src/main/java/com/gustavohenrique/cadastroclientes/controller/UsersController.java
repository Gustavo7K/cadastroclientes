package com.gustavohenrique.cadastroclientes.controller;

import com.gustavohenrique.cadastroclientes.model.Users;
import com.gustavohenrique.cadastroclientes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<List<Users>> registerUser(@Valid @RequestBody Users users) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUsers(users));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Users>> delete(@PathVariable UUID id){
        Optional<Users> userDelete = userService.deleteUsers(id);
        if (userDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
