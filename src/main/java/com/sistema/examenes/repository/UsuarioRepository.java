package com.sistema.examenes.repository;

import com.sistema.examenes.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByUsername(String username);

}

/** MUY BIEN EXPLICADO
 * Documentacion - Curso de Spring Boot (https://www.youtube.com/watch?v=RWT7sZvgbeY)
 */