package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    /** para iniciar session */
    public Usuarios findByUsername(String username);

    /** Esta consulta se usa para buscar usuarios repetidos al registrarse un new usuario */
    public Usuarios findByEmail(String email);
}
