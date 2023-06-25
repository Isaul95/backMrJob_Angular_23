package com.sistema.examenes.controllers;

import com.sistema.examenes.configuraciones.JwtUtils;
import com.sistema.examenes.entity.JwtRequest;
import com.sistema.examenes.entity.JwtResponse;
import com.sistema.examenes.entity.UsuarioEntity;
import com.sistema.examenes.excepciones.UsuarioNotFoundException;
import com.sistema.examenes.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*") // Permite el intercambio de recursos entre el back y el front, permite las solicitudes...
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (UsuarioNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException disabledException){
            throw new Exception("USUARIO DESHABILITADO: "+ disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Credenciales Invalidas: "+ badCredentialsException.getMessage());
        }
    }

    /**
     * Retornamos/cargamos el usuario actual que esta en session...
     * @param principal
     * @return
     */
    @GetMapping("/actual-usuario")
    public UsuarioEntity obtenerUsuarioActual(Principal principal){
        return (UsuarioEntity) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}