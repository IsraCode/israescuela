package com.example.israel1.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.israel1.model.AlumnoModel;
import com.example.israel1.repository.AlumnoRepository;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	public AlumnoRepository alumnoRepository;
	
	@GetMapping()
	public ResponseEntity<?> getAlumno(){
		return ResponseEntity.ok().body(alumnoRepository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getAlumno(@PathVariable("id") UUID id){
		return ResponseEntity.ok().body(alumnoRepository.findById(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> postAlumno(@RequestBody AlumnoModel misDatos){
		misDatos.setId( UUID.randomUUID());
		alumnoRepository.save(misDatos);
		return ResponseEntity.ok().body("Soy un Post");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateAlumno(@RequestBody AlumnoModel misDatos, @PathVariable("id") UUID id){
		AlumnoModel alumnoModel = new AlumnoModel();
		alumnoModel = alumnoRepository.findById(id).orElse(null);
		alumnoModel.setNombre(misDatos.getNombre());
		alumnoModel.setEdad(misDatos.getEdad());
		alumnoModel.setRut(misDatos.getRut());
		alumnoModel.setCurso(misDatos.getCurso());
		alumnoRepository.save(alumnoModel);
	
			return ResponseEntity.ok().body("Soy una actualización");
		}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAlumno(@RequestBody AlumnoModel misDatos, @PathVariable("id") UUID id){
		misDatos.setId( UUID.randomUUID());
		alumnoRepository.deleteById(id);
			return ResponseEntity.ok().body("Soy un borrador");
			
		
		}
	

	
}
