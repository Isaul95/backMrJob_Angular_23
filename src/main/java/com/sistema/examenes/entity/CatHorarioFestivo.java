package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_horario_festivo")
public class CatHorarioFestivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_festivo")
    private Long id_festivo;
    @Column(name = "horarios")
    private String horarios;

}
