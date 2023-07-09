package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_servicios")
public class CatServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long id_tipo;
    @Column(name = "tipo_servicio")
    private String tipo_servicio;
    @Column(name = "descripcion")
    private String descripcion;

}
