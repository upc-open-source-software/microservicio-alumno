package com.upc.instituto.alumno.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.instituto.alumno.entidades.Alumno;
import com.upc.instituto.alumno.repositorio.IAlumnoRepositorio;

@Service
public class AlumnoNegocio implements IAlumnoNegocio {

	@Autowired
	private IAlumnoRepositorio iAlumnoRepositorio;
	
	@Override
	public Alumno registrar(Alumno alumno) {
		return iAlumnoRepositorio.save(alumno);
	}

	@Override
	public Alumno buscar(Long codigo) throws Exception {
		return iAlumnoRepositorio.findById(codigo).orElseThrow(
				() -> new Exception("No se encontró la entidad"));
	}

	@Override
	public List<Alumno> listado() {
		return iAlumnoRepositorio.findAll();
	}

	@Override
	public Alumno actualizar(Alumno alumno) throws Exception {
		this.buscar(alumno.getCodigo());
		return iAlumnoRepositorio.save(alumno);
	}

}
