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
@Table(name = "detalle_servicios")
public class detalleServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id_detalle;
    @Column(name = "id_tipo_servicio")
    private Long id_tipo_servicio;
    // @Column(name = "nombre_servicio")  // no se usa en esta version
    // private String nombre_servicio; // no se usa en esta version
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "whatsapp")
    private String whatsapp;
    @Column(name = "rango_precios")
    private Long rango_precios;
    // @Column(name = "tipo_servicios")  // no se usa en esta version
    // private Long tipo_servicios;  // no se usa en esta version
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "codigo_postal")
    private String codigo_postal;
    @Column(name = "colonia")
    private Long colonia;
    @Column(name = "estado")
    private Long estado;
    @Column(name = "rango_servicio")
    private Long rango_servicio;
    @Column(name = "dias_servicio")
    private Long dias_servicio;
    @Column(name = "horario_servicio")
    private Long horario_servicio;
    @Column(name = "dias_festivos")
    private String dias_festivos;
    @Column(name = "horario_festivo")
    private Long horario_festivo;
    @Column(name = "id_usuario")
    private Long id_usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "servicio")
    private Set<UsuarioServicios> usuarioServicios = new HashSet<>();

}
