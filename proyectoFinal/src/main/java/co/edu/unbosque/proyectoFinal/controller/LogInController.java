package co.edu.unbosque.proyectoFinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.proyectoFinal.dto.LogInDTO;
import co.edu.unbosque.proyectoFinal.service.EmailService;
import co.edu.unbosque.proyectoFinal.service.LogInService;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = { "*" })
public class LogInController {

	@Autowired
	private LogInService loginServ;
	@Autowired
	private EmailService mailServ;

	public LogInController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crearcuenta")
	public ResponseEntity<String> crear(@RequestParam String usuario, @RequestParam String contrasenia,
			@RequestParam String correo) {
		LogInDTO nuevoUsuario = new LogInDTO(usuario, contrasenia, correo);
		int estado = loginServ.create(nuevoUsuario);
		if (estado == 0) {
			return new ResponseEntity<>("cuenta creada con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear cuenta", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/eliminarporusuario/{usuario}")
	public ResponseEntity<String> deleteByUsuario(@PathVariable String usuario) {
		int status = loginServ.deleteByUsuario(usuario);
		if (status == 0) {
			return new ResponseEntity<String>("cuenta eliminada por usuario con éxito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("cuenta no encontrada", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminarporcorreo/{correo}")
	public ResponseEntity<String> deleteByCorreo(@PathVariable String correo) {
		int status = loginServ.deleteByCorreo(correo);
		if (status == 0) {
			return new ResponseEntity<String>("cuenta eliminada por correo con éxito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("cuenta no encontrada", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/mostrar")
    public ResponseEntity<ArrayList<LogInDTO>> mostrarTodo() {
        ArrayList<LogInDTO> estudiantes = loginServ.findAll();
        if (estudiantes.isEmpty()) {
            return new ResponseEntity<ArrayList<LogInDTO>>(estudiantes, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<ArrayList<LogInDTO>>(estudiantes, HttpStatus.ACCEPTED);
        }
    }
	
	@PostMapping("/enviarcorreo")
	public String sendEmail(@RequestParam String to) {
        mailServ.sendEmail(to);
        return "Correo enviado exitosamente a " + to;
    }

}
