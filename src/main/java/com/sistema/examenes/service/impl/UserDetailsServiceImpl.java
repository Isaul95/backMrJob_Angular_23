package com.sistema.examenes.service.impl;

import com.sistema.examenes.entity.UsuarioEntity;
import com.sistema.examenes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = this.usuarioRepository.findByUsername(username);
          if(usuario == null){
              throw new UsernameNotFoundException("Usuario no encontrado");
          }
          return usuario;
    }
}
