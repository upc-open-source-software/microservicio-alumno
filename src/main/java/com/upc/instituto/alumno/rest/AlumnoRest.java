package com.upc.instituto.alumno.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.upc.instituto.alumno.entidades.Alumno;
import com.upc.instituto.alumno.negocio.IAlumnoNegocio;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(
	origins = "http://localhost:4200", 
	methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, 
	allowedHeaders = "*")
public class AlumnoRest {
	@Autowired
	private IAlumnoNegocio alumnoNegocio;

	private Logger LOGGER = LoggerFactory.getLogger(AlumnoRest.class);

	@GetMapping
	public ResponseEntity<?> listado() {
		Map<String, Object> response = new HashMap<>();

		try {
			return ResponseEntity.ok().body(this.alumnoNegocio.listado());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			response.put("error", e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
	}

	@PostMapping
	public ResponseEntity<?> registrar(@Valid @RequestBody Alumno alumno, BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		try {
			if (result.hasErrors()) {
				List<String> errores = result.getFieldErrors().stream()
						.map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
						.collect(Collectors.toList());
				response.put("errores", errores);

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoNegocio.registrar(alumno));

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			response.put("error", e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long codigo) {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<Alumno> optAlumno = this.alumnoNegocio.buscar(codigo);
			if (optAlumno.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(optAlumno.get());

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			response.put("error", e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@Valid @RequestBody Alumno alumno, BindingResult result,
			@PathVariable("id") Long codigo) throws Exception {
		Map<String, Object> response = new HashMap<>();
		try {
			if (result.hasErrors()) {
				List<String> errores = result.getFieldErrors().stream()
						.map(error -> "el campo '" + error.getField() + "' " + error.getDefaultMessage())
						.collect(Collectors.toList());
				response.put("errores", errores);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			Optional<Alumno> optAlumno = alumnoNegocio.buscar(codigo);
			if (optAlumno.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Alumno alumnoDB = optAlumno.get();
			alumnoDB.setNombres(alumno.getNombres());
			alumnoDB.setApellidos(alumno.getApellidos());
			alumnoDB.setFechaNacimiento(alumno.getFechaNacimiento());
			alumnoDB.setDireccion(alumno.getDireccion());
			alumnoDB.setCelular(alumno.getCelular());
			alumnoDB.setCorreo(alumno.getCorreo());
			alumnoDB.setIdDepartamento(alumno.getIdDepartamento());
			alumnoDB.setIdProvincia(alumno.getIdProvincia());
			alumnoDB.setIdDistrito(alumno.getIdDistrito());

			return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoNegocio.actualizar(alumnoDB));

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no existe en la base de datos", e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long codigo) throws Exception {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<Alumno> optAlumno = this.alumnoNegocio.buscar(codigo);
			if (optAlumno.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			this.alumnoNegocio.eliminar(codigo);
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			response.put("error", e.getMessage());
			return ResponseEntity.internalServerError().body(response);
		}
	}
}
