package com.gustavohenrique.cadastroclientes.infra;

import com.gustavohenrique.cadastroclientes.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return usersRepository.findByUsername(usuario)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
