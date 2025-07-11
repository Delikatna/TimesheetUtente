package com.axcent.User.repositories;

import com.axcent.User.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteDao extends JpaRepository<Utente,Long>
{
    Utente findByUsername(String username);
}
