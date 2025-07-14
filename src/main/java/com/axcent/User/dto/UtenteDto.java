package com.axcent.User.dto;

import com.axcent.User.entities.Utente;
import com.axcent.User.entities.enums.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto
{
    private Long id;
    private String username;
    private Ruolo ruoli;

    public UtenteDto(Utente ut)
    {
        this.id=ut.getId();
        this.username= ut.getUsername();
        this.ruoli = ut.getRuolo();
    }
}
