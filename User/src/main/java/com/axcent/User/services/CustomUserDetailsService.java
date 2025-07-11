package com.axcent.User.services;

import com.axcent.User.entities.Utente;
import com.axcent.User.repositories.UtenteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtenteDao utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = utenteRepository.findByUsername(username);

        return org.springframework.security.core.userdetails.User
                .withUsername(utente.getUsername())
                .password(utente.getPassword())
                .authorities(String.valueOf(utente.getRuolo())) // es: "USER", "ADMIN"
                .build();
    }
}