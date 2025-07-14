package com.axcent.User.repositories;

import com.axcent.User.entities.AnagraficaUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnagraficaUtenteDao extends JpaRepository<AnagraficaUtente,Long>
{
    @Query("SELECT a FROM AnagraficaUtente a WHERE a.utente.id = :id")
    AnagraficaUtente findByUtenteId(@Param("id") Long id);
}
