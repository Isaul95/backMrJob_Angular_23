package com.sistema.examenes.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor con todos los argumentos
@NoArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor vacio
@Entity
@Table(name = "ayuda")
public class Ayuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ayuda")
    private Long id_ayuda;
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(name = "nombre_completo")
    private String nombre_completo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "servicio_problema")
    private Long servicio_problema;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "email")
    private String email;


}
