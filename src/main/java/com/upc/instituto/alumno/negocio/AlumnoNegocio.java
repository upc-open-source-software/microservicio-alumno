package com.upc.instituto.alumno.negocio;

import java.util.List;
import java.util.Optional;

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
	public Optional<Alumno> buscar(Long codigo) {
		return iAlumnoRepositorio.findById(codigo);
	}

	@Override
	public List<Alumno> listado() {
		return iAlumnoRepositorio.findAll();
	}

	@Override
	public Alumno actualizar(Alumno alumno) {
		return iAlumnoRepositorio.save(alumno);
	}

	@Override
	public void eliminar(Long codigo) {
		iAlumnoRepositorio.deleteById(codigo);
	}
}
