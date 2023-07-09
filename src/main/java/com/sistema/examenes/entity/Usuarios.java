package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nombrecompleto;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled=true;
    private String perfil;


/**  ----------    VERSION FUNCIONAL DE MR JOB - COPIA     ----------- */
    @Column(name = "id_rol")
    private Long idRol;
    @Column(name = "id_negocios")
    private Long idNegocios;
    private int activo;
    private String direccion;
    private int edad;
    private String sexo;
    private String rfc;
    private String curp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_registro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_actualizacion;


    /*  Lo que hace este atributo antes de registrar agregue la fecha inmediantamente, una funcionalidad de Spring Boot*/
    @PrePersist
    public void prePersist(){
        this.fecha_registro = new Date();
    }

    //*Lo que hace este atributo es cada vez que se actualiza el registro actualiza la fecha inmediantamente, una funcionalidad de Spring Boot
    @PreUpdate
    public void preUpdate(){
        this.fecha_actualizacion = new Date();
    }


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore //a la hora de listar se esta deszializando, obtener estamos obteniendo JSON con el EAGER CICLA LOS DATOS REPEDITOS
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();


    /**  -------------------------------    Esta parte son para el JWT Token   --------------------------- */
    @Override
    public boolean isAccountNonExpired() {
        //return false; va a estar activo x cierto tiempo pero SI tiene que expirar, x eso se cambia de false - true
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        //return false;
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        //return false;
        return true;
    }

    /**    Colecction de roles - usuario    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null;
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol ->{
            autoridades.add(new Authority(usuarioRol.getRol().getNombre()));
        });
        return autoridades;
    }

}
