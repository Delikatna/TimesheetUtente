package com.axcent.User.dto;

import com.axcent.User.entities.AnagraficaUtente;
import com.axcent.User.entities.Utente;
import lombok.Data;

@Data
public class RegistrazioneDto
{
    private Utente utente;
    private AnagraficaUtente anagraficaUtente;

}
