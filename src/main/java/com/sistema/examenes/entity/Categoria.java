package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/** --------------------------------------------------
 * --------    ESTE NO SE USA PARA MR JOB -------------
 * ------------------------------------------------ */


@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String titulo;
    private String descripcion;

    /** cascade = CascadeType.ALL:
     * Si eliminamos esta categoria se van a eliminar todos lo examenes que esten relacionas con la categoria k se esta eliminando
     */
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Examen> examenes = new LinkedHashSet<>();

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(Set<Examen> examenes) {
        this.examenes = examenes;
    }

    public Categoria() {
    }
}
