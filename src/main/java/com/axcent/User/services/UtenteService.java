package com.axcent.User.services;

import com.axcent.User.dto.UtenteDto;
import com.axcent.User.entities.Utente;
import com.axcent.User.enums.Ruolo;
import com.axcent.User.repositories.UtenteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLSession;
import java.util.Collections;
import java.util.List;

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
}
