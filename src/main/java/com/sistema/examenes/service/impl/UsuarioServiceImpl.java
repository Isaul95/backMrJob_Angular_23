package com.sistema.examenes.service.impl;

import com.sistema.examenes.DTO.CatUsuarioDTO;
import com.sistema.examenes.DTO.Response;
import com.sistema.examenes.entity.*;
import com.sistema.examenes.repository.*;
import com.sistema.examenes.service.UsuarioService;
import com.sistema.examenes.utilerias.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    private static Logger Logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CatServiciosRepository catServiciosRepository;
    @Autowired
    private CatNegociosRepository catNegociosRepository;
    @Autowired
    private DetalleServiciosRepository detalleServiciosRepository;


    @Override
    @Transactional
    public Response guardarUsuario2(CatUsuarioDTO catUsuario) throws Exception {
        Response response = new Response();
        Usuarios usuarios = new Usuarios();
        RolEntity rol = new RolEntity();
        CatServicios servAgregado = null;
        CatNegocios negoc= null;
        try {

        Usuarios existeUsuario = usuarioRepository.findByEmail(catUsuario.getEmail());

        if (existeUsuario != null) {
            response.setCode(100);
            response.setDescripcion("El usuario ya Existe");
            Logger.info("Info en (UsuarioServiceImpl.Clas) -> guardarUsuario() -> El usuario ya Existe");
            //throw new UsuarioFoundException("El usuario ya Existe...!");
            } else {

                if (catUsuario.getTipoServicioOfrece() == null || catUsuario.getTipoServicioOfrece().isEmpty() &&
                        catUsuario.getNombreNegocio() == null || catUsuario.getNombreNegocio().isEmpty()) {

                    // 1 = ROL_JOBERS = (clientes)
                    rol.setRolId(1L);
                    rol.setNombre("Jobers");
                    rol.setDescripcion("Jobers son los Clientes");
                    usuarios.setIdRol(1L);
                } else {
                    Logger.info("El usuario en registro es un JOB.!");

                    CatServicios newServicios = new CatServicios();
                    newServicios.setTipo_servicio(catUsuario.getTipoServicioOfrece());
                    servAgregado = catServiciosRepository.save(newServicios);

                    CatNegocios negocio = new CatNegocios();
                    negocio.setIdServicios(servAgregado.getId_tipo()); /** --- agregando id_servicio en la tabla de negocios ---*/
                    negocio.setNombre(catUsuario.getNombreNegocio());
                    negoc = catNegociosRepository.save(negocio);

                    // 2 = ROL_JOB = (Prestador de servicio)
                    rol.setRolId(2L);
                    rol.setNombre("Job");
                    rol.setDescripcion("Prestadores de servicios");

                    usuarios.setIdRol(2L);
                    usuarios.setIdNegocios(negoc.getId()); /** --- Isaul agregando ir negocio en la tabla de usuarios ---*/
                }

                rolRepository.save(rol);

                // Encriptamos la contraseña que trae del front el obj -> usuarioEntity
                usuarios.setPassword(this.bCryptPasswordEncoder.encode(catUsuario.getPassword()));

                usuarios.setNombrecompleto(catUsuario.getNombrecompleto());
                usuarios.setEmail(catUsuario.getEmail());
                usuarios.setActivo(1);

                // se traspasa como collection el rol para cumplir con la llave compuesta
                Set<UsuarioRol> usuarioRoles = new HashSet<>();
                UsuarioRol usuarioRol = new UsuarioRol();
                usuarioRol.setUsuario(usuarios);
                usuarioRol.setRol(rol);
                usuarioRoles.add(usuarioRol);

                usuarios.setPassword(usuarios.getPassword());
                usuarios.setTelefono(catUsuario.getTelefono());
                usuarios.setUsername(catUsuario.getEmail());

                usuarios.getUsuarioRoles().addAll(usuarioRoles);

            existeUsuario = usuarioRepository.save(usuarios);

                /**
                 * Se hace el registro en table detalle_servicios para tener el servicio asociado al JOB y mostrar los servicios en Pantalla -> Mis Servicios
                 */
                if (catUsuario.getTipoServicioOfrece() != null && catUsuario.getNombreNegocio() != null){
                    System.out.println("CONDICION -> " + catUsuario.getTipoServicioOfrece() + " ->" + catUsuario.getNombreNegocio());
                    detalleServicios detServiceAgregado = new detalleServicios();
                    detServiceAgregado.setId_tipo_servicio(servAgregado.getId_tipo());
                    detServiceAgregado.setId_usuario(existeUsuario.getId()); // id usuario
                    detalleServiciosRepository.save(detServiceAgregado);
                }

                Logger.info("Usuario guardado exitosamente...!");
                response.setCode(200);
                response.setDescripcion("Usuario guardado con Exito");
            }
        } catch (Exception e){
            response.setCode(500);
            response.setDescripcion(Messages.MSERROR_GUARDAR_USER);
            Logger.error("Error en (UsuarioServiceImpl.Clas) -> guardarUsuario2()");
        }
        return response;
    }





    @Override
    public Response obtenerUsuario(String usuario) {
        Response response = new Response();
        try{
            Usuarios datesUser = usuarioRepository.findByUsername(usuario);

            response.setDatos(datesUser);
            response.setCode(200);
            response.setDescripcion("Usuario guardado con Exito");

        } catch (Exception e){
            response.setCode(500);
            response.setDescripcion(Messages.MSERROR_LOGIN);
            Logger.error("Error en (UsuarioServiceImpl.Clas) -> obtenerUsuario()");
        }
        return response;
    }



} // Fin

