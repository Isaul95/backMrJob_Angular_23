package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examenId;
    private String titulo;
    private String descripcion;
    private String puntosMax;
    private String numeroDePreguntas;
    private boolean activov = false;

    /**
     * Muchos examenes le van a poder pertenecer una sola categoria...
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    /** cascade = CascadeType.ALL:
     * Si eliminamos un exmen se van a eliminar todas las preguntas que esten relacionas...
     */
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pregunta> preguntas = new HashSet<>();

    public Long getExamenId() {
        return examenId;
    }

    public void setExamenId(Long examenId) {
        this.examenId = examenId;
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

    public String getPuntosMax() {
        return puntosMax;
    }

    public void setPuntosMax(String puntosMax) {
        this.puntosMax = puntosMax;
    }

    public String getNumeroDePreguntas() {
        return numeroDePreguntas;
    }

    public void setNumeroDePreguntas(String numeroDePreguntas) {
        this.numeroDePreguntas = numeroDePreguntas;
    }

    public boolean isActivov() {
        return activov;
    }

    public void setActivov(boolean activov) {
        this.activov = activov;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Examen() {
    }
}

