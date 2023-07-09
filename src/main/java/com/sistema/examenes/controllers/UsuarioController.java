package com.sistema.examenes.controllers;

import com.sistema.examenes.DTO.CatUsuarioDTO;
import com.sistema.examenes.DTO.Response;
import com.sistema.examenes.service.UsuarioService;
import com.sistema.examenes.utilerias.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private static Logger Logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * Registro de Job o Jobber
     */
    @PostMapping("/")
    public Response guardarUsuario(@RequestBody CatUsuarioDTO catUsuario) throws Exception{
        try{
            return usuarioService.guardarUsuario2(catUsuario);
        } catch (Exception e){
            Logger.info("Error en (UsuarioController.Clas) -> guardarUsuario" + e.getMessage());
            return new Response(500, Messages.MS500);
        }
    }


    /**
     * Iniciar session -- Login
     */
    @GetMapping("/{username}")
    public Response iniciarSession(@PathVariable("username") String username){
        try{
            return usuarioService.obtenerUsuario(username);
        } catch (Exception e){
            Logger.info("Error en (UsuarioController.Clas) -> iniciarSession" + e.getMessage());
            return new Response(500, Messages.MS500);
        }
    }


}
