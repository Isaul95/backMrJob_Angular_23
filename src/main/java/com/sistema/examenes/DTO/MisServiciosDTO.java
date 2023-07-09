package com.sistema.examenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MisServiciosDTO {

    private Long id_servicio;
    //private String nombre_servicio;
    private String descripcion;
    private String telefono;
    private String whatsapp;
    private Long rango_precios;
    //private Long tipo_servicios;
    private String direccion;
    private String codigo_postal;
    private Long colonia;
    private Long estado;
    private Long rango_servicio;
    private Long dias_servicio;
    private Long horario_servicio;
    private String dias_festivos;
    private Long horario_festivo;
    private Long id_usuario;
    private Long id_tipo_servicio;
    private String otro_tipo_servicio;
    private String otro_kilometro;

}
