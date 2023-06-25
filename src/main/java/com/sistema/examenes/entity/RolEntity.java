package com.sistema.examenes.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RolEntity {

    @Id
    private Long rolId;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
    // constructor vacio
    public RolEntity() {

    }
}

/**
 * 1.- @OneToMany: Un rol de editor le puede pertencer a muchos usuarios
 * 2.- cascade = CascadeType.ALL; Cuando eliminemos este rol tambien elimine el rol que estaba relacionado a los demas usuarios las k estan relacionadas
 *
 * 3.- fetch = FetchType.LAZY; cuando vamos a usar una busqueda se debe de indicar como se va arealizar la busqueda
 *
 * 4.- mappedBy = "rol": la propietaria va ser rol se indica en la clase -> UsuarioRolEntity
 *
 */
