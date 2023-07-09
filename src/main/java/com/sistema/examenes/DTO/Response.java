package com.sistema.examenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data // Esto es de Lombook -> Con esto creamos todos los getter y setter
@AllArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor con todos los argumentos
@NoArgsConstructor // Esto es de Lombook -> Con esto creamos un constructor vacio
public class Response {

    private int Code;
    private String Descripcion;
    private List<?> Result;
    private Object datos;


    /**
     * Coinstructor personalizado
     */
    public Response(int code, String descripcion) {
        Code = code;
        Descripcion = descripcion;
    }

}
