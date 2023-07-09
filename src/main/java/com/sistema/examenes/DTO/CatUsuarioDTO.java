package com.sistema.examenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Esto es de Lombook -> Con esto creamos todos los getter y setter
@AllArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor con todos los argumentos
@NoArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor vacio
public class CatUsuarioDTO {

    private Long id;
    private String nombrecompleto;
    private String password;
    private String email;
    private String telefono;
    private String perfil;

    private int activo;
    private String username;
    private String direccion;
    private int edad;
    private String sexo;
    private String rfc;
    private String curp;
    private String tipoServicioOfrece;
    private String nombreNegocio;

}
