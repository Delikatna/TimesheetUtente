package com.axcent.User.services;

import com.axcent.User.entities.AnagraficaUtente;
import com.axcent.User.entities.Utente;
import com.axcent.User.repositories.AnagraficaUtenteDao;
import com.axcent.User.repositories.UtenteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnagraficaService
{
    private final AnagraficaUtenteDao adao;
    private final UtenteDao utenteDao;
    public AnagraficaUtente registrazioneAnagrafica(AnagraficaUtente au,Utente utente)
    {
        au.setNome(au.getNome());
        au.setCognome(au.getCognome());
        au.setNumTelefono(au.getNumTelefono());
        au.setDob(au.getDob());
        au.setSede(au.getSede());
        au.setMansione(au.getMansione());
        au.setUtente(utente);

        return adao.save(au);

    }

    public AnagraficaUtente findByIdUtente(Long id)
    {
        return adao.findByUtenteId(id);
    }
}
