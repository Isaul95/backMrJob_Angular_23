package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled=true;
    private String perfil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore //a la hora de listar se esta deszializando, obtener estamos obteniendo JSON con el EAGER CICLA LOS DATOS REPEDITOS
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    /**   Esta parte son para el JWT Token  */

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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null;
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol ->{
            autoridades.add(new Authority(usuarioRol.getRol().getNombre()));
        });
        return autoridades;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
    // constructor vacio
    public UsuarioEntity() {

    }

}

/**
 * @Entity: Es una anotacion que me va a servir para indicar k esta clase es una entidad y se mapee con la base de datos
 *
 * @Table(name = "usuarios"): Es para indicarle el nombre de la tabla de la DB, cuando no exista esta tabla en la DB es decir que es nueva al momento de compilar
 * el proyecto esta entidad se mapea y se crea la tabla por primera vez en la DB con respecto a los campos y tipos de datos que estan declarados en esta clase(Entidad)
 *
 * @Id: esta anotacion le indica el campo siguiente que va a ser unico
 *
 * @GeneratedValue(strategy = GenerationType.IDENTITY): Cada ves que yo haga un nuevo registro sea auto-incremental
 *
 * ---------------------------------------------------------------------------------------------------------------------------------
 *
 * @OneToMany: Un registro de esta entidad (1 usuario) va a poder tener MUCHOS ROLES
 *
 * QUE ES CASCADE EN JPA:
 * cascade = CascadeType.ALL: Cuando se aplique esto -> (@OneToMany) a un usuario de esta entidad(tabla) le va afectar a las entidades hijas cascada de tipo ALL es decir donde
 * este usuario lo esten usando o este registrado en otras tablas. EJEMPLO: en una relacion USUARIO - DIRECCION si eliminamos el usuario en la entidad Direccion no tiene ningun sentido
 * esto quiere decir que tambien debe de eliminarse en la tabla de Direccion.
 *
 *
 * EAGER: Ansocio
 * LAZY: Peresoso
 *
 * fetch = FetchType.EAGER: (todos los datos de las entidades relacionadas) Cuando se lista un registro de la tabla usuario EAGER y si esta relacionado en otras tablas te trae toda esa informacion relacionad
 * a las demas tablas
 *
 * LAZY: No te manda todos los datos relacionados de las tablas, simplemete en este caso solo nos regresaria los datos de los usuarios mas no lo demas datos que estan relacionadas
 *
 * DEFINICION: APUNTA A LA ENTIDAD PROPIETARIA DE LA RELACION...
 * mappedBy = "usuario": Le estamos indicando que este usuario va ser el propietario, todo_esta_linea -> del set usuarioRoles va a obtener todos los roles y se los va asignar a este -> "usuario"
 *
 */