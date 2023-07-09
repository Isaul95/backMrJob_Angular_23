package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_negocios")
public class CatNegocios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_servicios")
    private Long idServicios;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "negocio")
    private Set<UsuarioNegocios> usuarioNegocios = new HashSet<>();

}
