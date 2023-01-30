package com.upc.instituto.alumno.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.upc.instituto.alumno.entidades.Alumno;
import com.upc.instituto.alumno.negocio.IAlumnoNegocio;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRest {
	@Autowired
	private IAlumnoNegocio alumnoNegocio;

	@GetMapping
	public List<Alumno> listado() {
		return this.alumnoNegocio.listado();
	}
	
	@PostMapping
	public Alumno registrar(@RequestBody Alumno alumno) {
		return this.alumnoNegocio.registrar(alumno);
	}
	
	@GetMapping("/{id}")
	public Alumno buscar(@PathVariable("id") Long codigo) {
		try {
			return this.alumnoNegocio.buscar(codigo);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no existe en la base de datos", e);
		}
	}
	
	@PutMapping("/{id}")
	public Alumno actualizar(@RequestBody Alumno alumno, @PathVariable("id") Long codigo) throws Exception {
		try {
			alumno.setCodigo(codigo);
			return this.alumnoNegocio.actualizar(alumno);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no existe en la base de datos", e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long codigo) throws Exception {
		try {
			this.alumnoNegocio.eliminar(codigo);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no existe en la base de datos", e);
		}		
	}
}
