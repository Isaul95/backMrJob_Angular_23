package com.sistema.examenes.service;

import com.sistema.examenes.entity.UsuarioEntity;
import com.sistema.examenes.entity.UsuarioRol;
import java.util.Set;

public interface UsuarioService {

    /**
     * Este metodo lo que va a guardar es un nuevo usuario
     * y le vasmos a pasar un conjunto de usuarioRoles, es un conjunto de roles que se le va asignar al new usuario
     * @throws Exception
     * POR-QUE CREAMOS UNA CLASE APARTE? Cuando se trabaja con relaciones de uno - muchos por ambos lados es RECOMENDABLE
     * NORMALIZAR y crea una tabla intermedia llamada -> UsuarioRolEntity
     */
    public UsuarioEntity guardarUsuario(UsuarioEntity usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public UsuarioEntity obtenerUsuario(String usuario);

    public void eliminarUsuario(Long usuarioId);


}
