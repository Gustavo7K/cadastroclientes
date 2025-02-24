package com.gustavohenrique.cadastroclientes.service;

import com.gustavohenrique.cadastroclientes.model.Users;
import com.gustavohenrique.cadastroclientes.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> saveUsers(Users users){
        users.setSenha(passwordEncoder.encode(users.getSenha()));
        usersRepository.save(users);
        return listUsers();
    }

    public List<Users> listUsers(){
        return usersRepository.findAll();
    }
}
