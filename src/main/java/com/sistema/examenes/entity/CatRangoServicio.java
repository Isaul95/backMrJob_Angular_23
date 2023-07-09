package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_rango_servicio")
public class CatRangoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rango")
    private Long id_rango;
    @Column(name = "rango")
    private String rango;

}
