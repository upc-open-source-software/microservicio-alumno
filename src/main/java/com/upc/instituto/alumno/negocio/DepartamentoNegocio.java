package com.upc.instituto.alumno.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.instituto.alumno.entidades.Departamento;
import com.upc.instituto.alumno.repositorio.IDepartamentoRepositorio;

@Service
public class DepartamentoNegocio implements IDepartamentoNegocio {

	@Autowired
	private IDepartamentoRepositorio iDepartamentoRepositorio;

	@Override
	public List<Departamento> listado() {
		return iDepartamentoRepositorio.findAll();
	}

}
