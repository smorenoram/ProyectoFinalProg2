package co.edu.unbosque.proyectoFinal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.proyectoFinal.model.LogIn;

public interface LogInRepository extends CrudRepository<LogIn, Integer>{
	
	Optional<LogIn>findByUsuario(String usuario);
	Optional<LogIn>findByCorreo(String correo);

}
