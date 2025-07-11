package com.axcent.User.dto;

import com.axcent.User.entities.AnagraficaUtente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnagraficaUtenteDto
{
    private Long id;
    private String nome;
    private String cognome;
    private String sede;
    private String numTelefono;
    private Date dob;
    private String mansione;

    public AnagraficaUtenteDto(AnagraficaUtente anUt)
    {
        this.id= anUt.getId();
        this.nome= anUt.getNome();
        this.cognome = anUt.getCognome();
        this.sede= anUt.getSede();
        this.numTelefono = anUt.getNumTelefono();
        this.dob= anUt.getDob();
        this.mansione= anUt.getMansione().toString();
    }
}
