package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_colonia")
public class CatColonia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colonia")
    private Long id_colonia;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "clave")
    private String clave;

}
