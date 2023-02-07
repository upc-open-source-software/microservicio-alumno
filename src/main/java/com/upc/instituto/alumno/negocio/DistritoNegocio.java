package com.upc.instituto.alumno.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.instituto.alumno.entidades.Distrito;
import com.upc.instituto.alumno.repositorio.IDistritoRepositorio;

@Service
public class DistritoNegocio implements IDistritoNegocio {

	@Autowired
	private IDistritoRepositorio iDistritoRepositorio;

	@Override
	public List<Distrito> listado() {
		return iDistritoRepositorio.findAll();
	}

}
