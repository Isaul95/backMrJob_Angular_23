package com.sistema.examenes.repository;

import com.sistema.examenes.entity.detalleServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleServiciosRepository extends JpaRepository<detalleServicios, Long> {

    /* @Query(value = "SELECT id_servicio, nombre_servicio FROM cat_servicios WHERE id_servicio in (2,3,4,5)",nativeQuery = true)
       List<String> findAllServicesUsuario(MisServiciosDTO idUsuario);
     */

    @Query(value = "SELECT id_tipo, tipo_servicio FROM cat_servicios",nativeQuery = true)
    List<Object[]> findAllCatServices();


    @Query(value = "SELECT ds.id_detalle, cs.tipo_servicio AS nombre_servicio, cu.nombre_completo, ds.descripcion, ds.telefono, ds.whatsapp, ds.rango_precios, crp.precios, ds.id_tipo_servicio, " +
                   "ds.direccion, ds.codigo_postal, ds.colonia, cco.colonia AS nombre_colonia, ds.estado, ces.estado AS nombre_estado, ds.rango_servicio, crs.rango, " +
                   "ds.dias_servicio, cds.dias, ds.horario_servicio, chs.horarios, ds.dias_festivos, ds.horario_festivo, cfe.horarios AS horario_fest " +
                   "FROM detalle_servicios ds " +
                   "INNER JOIN cat_servicios cs ON cs.id_tipo = ds.id_tipo_servicio " +
                   "INNER JOIN cat_usuarios cu ON cu.id_usuario  = ds.id_usuario " +
                   "LEFT JOIN cat_rango_precios crp ON crp.id_rango = ds.rango_precios " +
                   "LEFT JOIN cat_colonia cco ON cco.id_colonia = ds.colonia " +
                   "LEFT JOIN cat_estados ces ON ces.id_estado = ds.estado " +
                   "LEFT JOIN cat_rango_servicio crs ON crs.id_rango = ds.rango_servicio " +
                   "LEFT JOIN cat_dias_servicio cds ON cds.id_dias = ds.dias_servicio " +
                   "LEFT JOIN cat_horario_servicio chs ON chs.id_horario = ds.horario_servicio " +
                   "LEFT JOIN cat_horario_festivo cfe ON cfe.id_festivo = ds.horario_festivo " +
                   "WHERE ds.id_usuario =:identUsuario " +
                   "order by ds.id_tipo_servicio ASC",nativeQuery = true)
    public abstract List<Object[]> findServicesCategoriaByUser(@Param("identUsuario") int identUsuario);
}
