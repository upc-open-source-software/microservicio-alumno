package com.upc.instituto.alumno.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.instituto.alumno.entidades.Provincia;
import com.upc.instituto.alumno.repositorio.IProvinciaRepositorio;

@Service
public class ProvinciaNegocio implements IProvinciaNegocio {

	@Autowired
	private IProvinciaRepositorio iProvinciaRepositorio;
	
	@Override
	public List<Provincia> listado() {
		return iProvinciaRepositorio.findAll();
	}

}
