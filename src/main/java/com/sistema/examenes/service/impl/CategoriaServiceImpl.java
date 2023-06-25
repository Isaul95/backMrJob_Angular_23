package com.sistema.examenes.service.impl;

import com.sistema.examenes.entity.Categoria;
import com.sistema.examenes.repository.CategoriaRepository;
import com.sistema.examenes.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public Categoria agregarCategoria(Categoria categoria) {


        return categoriaRepository.save(categoria);

    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategoria() {
        return new LinkedHashSet<> (categoriaRepository.findAll());
    }

    @Override
    public Categoria obtenerCategoria(Long cateriaId) {
        return categoriaRepository.findById(cateriaId).get();
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        categoriaRepository.delete(categoria);
    }
}
