package com.sistema.examenes.service.impl;

import com.sistema.examenes.entity.UsuarioEntity;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.repository.RolRepository;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service // Esta va a ser una clase de servicio
public class UsuarioServiceImpl implements UsuarioService{
    /**
     * En esta clase vamos a INYECTAR la INYECCION DE DEPENDENCIAS
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    /***
     * -----------------     ISAUL: PRIMERO METODO PARA GUARDAR USUARIO...    -------------------------------
     * @param usuario
     * @param usuarioRoles
     */
    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
    /**
     * Usamo JPA -> usuarioRepository es aki donde tenemos declarados las Entitys.
     * findByUsername -> Como se usa JPA(JpaRepository) los metodos ya estan declarados por default, se esta apuntando a las
     * se estan utilizando los estandares de JPA
     */
        // Consultamos/buscamos un usuario, antes de insertar verificamos si ya existe.
        UsuarioEntity usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if(usuarioLocal != null){
            System.out.println("El usuario ya Existe...!");
            throw new UsuarioFoundException("El usuario ya Existe...!");
        }else{
            for (UsuarioRol userRol:usuarioRoles){ // Recorremos roles del conjunto de -> Set<UsuarioRol>
                rolRepository.save(userRol.getRol());
            }
        }
        // usuario => obtenemos cada uno de los roles y asignar todo_la lista de roles
        usuario.getUsuarioRoles().addAll(usuarioRoles);
        usuarioLocal = usuarioRepository.save(usuario); // Le asignamos todo_a usuarioLocal

    return usuarioLocal;
    }


    /***
     * -----------------     ISAUL: SEGUNDO METODO PARA ELIMINAR USUARIO...    -------------------------------
     * @param usuario
     * @return
     */
    @Override
    public UsuarioEntity obtenerUsuario(String usuario) {
        return usuarioRepository.findByUsername(usuario);
    }


    /**
     * -----------------     ISAUL: TERCER METODO PARA ELIMINAR USUARIO...    -------------------------------
     * @param usuarioId
     */
    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }


} // Fin

