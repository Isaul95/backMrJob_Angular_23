package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_horario_servicio")
public class CatHorarioServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long id_horario;
    @Column(name = "horarios")
    private String horarios;

}
