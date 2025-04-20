package co.edu.unbosque.proyectoFinal.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.proyectoFinal.repository.LogInRepository;

import co.edu.unbosque.proyectoFinal.dto.*;
import co.edu.unbosque.proyectoFinal.model.LogIn;
@Service
public class LogInService {
	
	@Autowired
	private LogInRepository loginRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public LogInService() {
		// TODO Auto-generated constructor stub
	}
	
	public int create(LogInDTO data) {

		LogIn entity = modelMapper.map(data, LogIn.class);

		try {

			loginRepo.save(entity);

			return 0;

		} catch (Exception e) { // sql execcion

			return 1;

		}

	}
	
	
	public int deleteByUsuario(String usuario) {
		Optional<LogIn> user = loginRepo.findByUsuario(usuario);
		if(user.isPresent()) {
			loginRepo.delete(user.get());
			return 0;
		} else {
			return 1; 
		}
	}
	
	public int deleteByCorreo(String correo) {
		Optional<LogIn>viejo = loginRepo.findByCorreo(correo);
		if(viejo.isPresent()) {
			return 0;
		} else {
			return 1; 
		}
	}
	
	public ArrayList<LogInDTO> findAll() {
		ArrayList<LogIn> entityList = (ArrayList<LogIn>) loginRepo.findAll();
		ArrayList<LogInDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {
			LogInDTO dto = modelMapper.map(entity, LogInDTO.class);
			dtoList.add(dto);
		});

		return dtoList;
	}
	
	
	
	
	

}
