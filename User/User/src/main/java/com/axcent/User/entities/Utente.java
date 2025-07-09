package com.axcent.User.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Ruolo> ruolo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="anagrafica_id", referencedColumnName = "id")
    private AnagraficaUtente anagraficaUtente;


}
