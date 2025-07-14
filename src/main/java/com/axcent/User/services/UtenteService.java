package com.axcent.User.services;

import com.axcent.User.entities.Utente;
import com.axcent.User.entities.enums.Ruolo;
import com.axcent.User.repositories.UtenteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteService
{
    private final UtenteDao udao;
    private final PasswordEncoder passwordEncoder;

    public Utente registrazioneUtente(Utente ut)
    {

        ut.setRuolo(Ruolo.USER);
        ut.setPassword(passwordEncoder.encode(ut.getPassword()));

        return udao.save(ut);
    }

    public Utente findByUsername(String username)
    {
        Utente ut = udao.findByUsername(username);
        if(ut==null)
            throw new RuntimeException("non è stato trovato nessun utente");


        return ut;
    }

    public  Utente findById(Long id)
    {
        Utente ut = udao.findById(id)
                .orElseThrow(()-> new RuntimeException("Utente non trovato"));
        return ut;
    }
}
