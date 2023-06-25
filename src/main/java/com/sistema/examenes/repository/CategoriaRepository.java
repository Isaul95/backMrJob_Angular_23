package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    //List<Object> findByUser(Long categoriaId);
    // select * from usuarios where usuario = 'isaul';


    //obtenerAllCategoriasTabla { JPA = JDBC -> (CONSULTAS NATIVAS)
        // select * from table where nombre = '';
    //}

}// Fin clase
