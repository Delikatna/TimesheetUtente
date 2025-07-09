package com.axcent.User.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnagraficaUtente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome,cognome,sede,numTelefono;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private Mansione mansione;

    @OneToOne(mappedBy = "anagraficaUtente")
    private Utente utente;
}
