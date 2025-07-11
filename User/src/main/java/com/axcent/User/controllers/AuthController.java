package com.axcent.User.controllers;

import com.axcent.User.dto.RegistrazioneDto;
import com.axcent.User.entities.AnagraficaUtente;
import com.axcent.User.entities.Utente;
import com.axcent.User.responses.AuthRequest;
import com.axcent.User.responses.AuthResponse;

import com.axcent.User.security.JwtTokenProvider;
import com.axcent.User.services.AnagraficaService;
import com.axcent.User.services.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController
{
    private final AuthenticationManager authenticationManager;
    private final UtenteService utenteService;
    private final AnagraficaService anagraficaService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/registrazione")
    public ResponseEntity<?> registrazione(@RequestBody RegistrazioneDto registrazione)
    {
        try{
            utenteService.registrazioneUtente(registrazione.getUtente());
            anagraficaService.registrazioneAnagrafica(registrazione.getAnagraficaUtente(),registrazione.getUtente());
            return ResponseEntity.ok(Map.of("message","Registrazione avvenuta con successo"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest loginRequest)
    {
        try{
           Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           loginRequest.getUsername(),
                           loginRequest.getPassword()));

           Long idUser = utenteService.findByUsername(loginRequest.getUsername()).getId();

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);

            String role = authentication.getAuthorities()
                    .stream()
                    .findFirst()
                    .map(authority -> authority.getAuthority())
                    .orElse("SCONOSCIUTO");

            return ResponseEntity.ok(new AuthResponse(jwt, loginRequest.getUsername(), role, idUser));

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("error: "+e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?>logout(@RequestHeader("Authorization") String authHeader)
    {
        return ResponseEntity.ok(Map.of("message","Logout effetuato con successo"));
    }

}
