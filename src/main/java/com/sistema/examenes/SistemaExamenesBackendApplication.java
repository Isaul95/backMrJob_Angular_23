package com.sistema.examenes;

import com.sistema.examenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {
	// CommandLineRunner: Para ejecutar el programa desde run se ingrese los datos manual y los puede imprimir en consola

	/**
	 * Inyectar el service: xq INYECTAS LA INTERFACE Y NO LA IMPLEMENTACION?: XQ SPRING CUANDO TU AUTOMATICAMENTE INYECTAS UN SERVICE SE SOBRE
	 * ENTIENDE QUE ESTE VA A BUSCAR A SU INTERFACE Y VA A LLAMAR UN METODO...
	 */
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception { // Imprimir datos por consola
		 //Todo_esto se comento por que fue la primera prueba que isimos, despues se icieron pruebas con postman
		/*UsuarioEntity usuario = new UsuarioEntity();

		usuario.setNombre("Isaul");
		usuario.setApellido("Hdez");
		usuario.setUsername("saul");
		usuario.setPassword(bCryptPasswordEncoder.encode("123"));
		usuario.setEmail("rihr_952@hotmail.com");
		usuario.setTelefono("7331170055");
		usuario.setPerfil("foto.png");

		RolEntity rol = new RolEntity();
		rol.setRolId(1L); // Esta es la forma de representar los tipos de datos LOGN = 1L -> L=Long
		rol.setNombre("ADMIN");

		Set<UsuarioRolEntity> usuarioRoles = new HashSet<>();
		UsuarioRolEntity usuarioRolEntity = new UsuarioRolEntity();
		usuarioRolEntity.setRol(rol); // Establecerle el rol que acabamos de crear -> ADMIN
		usuarioRolEntity.setUsuario(usuario); // usuario = es el usuario que estamos metiendo "mis datos"

		// AGREGAMOS EL ->(usuarioRolEntity) QUE YA CONTIENE/YA LE INCRUTAMOS LOS DATOS rol y usuario
		usuarioRoles.add(usuarioRolEntity);

		// Guardar esta lista/conjunto de datos ->(rol y usuario) se mandan los objetos que contienen los datos...
		UsuarioEntity guardaUsuario = usuarioService.guardarUsuario(usuario, usuarioRoles);

		System.out.println("DATOS:"+guardaUsuario.getUsername());*/

	}

}
