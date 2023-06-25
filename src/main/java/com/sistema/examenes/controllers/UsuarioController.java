package com.sistema.examenes.controllers;

import com.sistema.examenes.entity.RolEntity;
import com.sistema.examenes.entity.UsuarioEntity;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;


@RestController // Para manejar JSON, controller relacionado con le Front
@RequestMapping("/usuarios") // Para acceder a este API-REST tenemos que agregar el (/usuarios) ->EndPoint
@CrossOrigin("*")
/** Para poder usar ek front - back se necesita un CORS para poder aceptar intercambio de recursos mediante http client
 *  se necesita permitirlo con el @CrossOrigin ("*") => con esto es permitirle cualkier peticion GET, POST, ETC.
 */

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /** ------------------------  ISAUL: PRIMERO METODO PARA GUARDAR USUARIO   -------------------------------
     * VAMOS A HACER UNA PETICION ->(POST) =>@PostMapping
     * @RequestBody: Nos sirve para mandar este objeto con sus datos
     * @param usuarioEntity
     */
    @PostMapping("/")
    public UsuarioEntity guardarUsuario(@RequestBody UsuarioEntity usuarioEntity) throws Exception{
        System.out.print("LLego al controller linea #32");
        usuarioEntity.setPerfil("default.png");

        // Encriptamos la contraseña que trae del front el obj -> usuarioEntity
        usuarioEntity.setPassword(this.bCryptPasswordEncoder.encode(usuarioEntity.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        RolEntity rol = new RolEntity();
        rol.setRolId(2L); // Esta es la forma de representar los tipos de datos LOGN = 1L -> L=Long
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuarioEntity);
        usuarioRol.setRol(rol);
System.out.print("-##500##--->>> "+usuarioEntity.toString());
        System.out.print("-##599##--->>> "+usuarioRol.getUsuario().toString());
        usuarioRoles.add(usuarioRol);

        return usuarioService.guardarUsuario(usuarioEntity, usuarioRoles);
    }


    /** ------------------------  ISAUL: SEGUNDO METODO PARA OBTENER USUARIO   -------------------------------
     * 1.- @GetMapping: Obtener/consultar... -> {username}: es el valor que viene desde el front es el mismo a pasar al metodo
     * 2.- @PathVariable: Pasar variable que viene desde el front
     * @param username
     *
     */
    @GetMapping("/{username}")
    public UsuarioEntity obtenerUsuario(@PathVariable("username") String username) {

        return usuarioService.obtenerUsuario(username);
    }


    /** ------------------------  ISAUL: TERCER METODO PARA ELIMINAR USUARIO   -------------------------------
     * 1.- @DeleteMapping: peticion para eliminar registro en base a un IDENTIFICADOR...
     * @param usuarioId
     *
     */
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {

        usuarioService.eliminarUsuario(usuarioId);
    }


    } // FIN...
