package com.sistema.examenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AyudaDTO {

    private Long id_ayuda;
    private Long id_usuario;
    private String nombre_completo;
    private String telefono;
    private Long servicio_problema;
    private String mensaje;
    private String email;

}
