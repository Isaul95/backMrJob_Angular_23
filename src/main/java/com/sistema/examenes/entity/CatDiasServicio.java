package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_dias_servicio")
public class CatDiasServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dias")
    private Long id_dias;
    @Column(name = "dias")
    private String dias;

}
