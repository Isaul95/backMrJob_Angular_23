package com.sistema.examenes.entity;

import javax.persistence.*;

@Entity
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    private RolEntity rol;

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    // constructor vacio
    public UsuarioRol(){

    }

}

/** Esta es la clase que tiene las relaciones -> ManyToOne
 *
 * 1.- Se agrego codigo en la clase UsuarioEntity y en RolEntity
 *
 * 2.- @ManyToOne (fetch = FetchType.EAGER) de la linea #12 del usuario: MUCHOS roles le van a poder pertenecer a UN usuario <-- PARA ESTO EN ESTA CLASE EN LA CLASE
 * DE UsuarioEntity hay es donde tambien tiene la anotaciones de uno a muchos es la CONTRAPARTE
 *
 * 3.- @ManyToOne(fetch = FetchType.EAGER): muchos usuarios van a poder pertenecer un solo ROL
 *
 */