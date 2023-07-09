package com.sistema.examenes.service;

import com.sistema.examenes.DTO.CatUsuarioDTO;
import com.sistema.examenes.DTO.Response;

public interface UsuarioService {

    Response guardarUsuario2(CatUsuarioDTO catUsuario) throws Exception;

    Response obtenerUsuario(String username);



}
