package com.gustavohenrique.cadastroclientes.repository;

import com.gustavohenrique.cadastroclientes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository <Users, UUID>{
}
