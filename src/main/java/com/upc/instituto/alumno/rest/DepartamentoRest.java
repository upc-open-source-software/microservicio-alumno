package com.upc.instituto.alumno.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upc.instituto.alumno.entidades.Departamento;
import com.upc.instituto.alumno.negocio.IDepartamentoNegocio;

@RestController
@RequestMapping("/api/departamentos")
/*
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST}, allowedHeaders = "*")
*/
@CrossOrigin("*")
public class DepartamentoRest {
	@Autowired
	private IDepartamentoNegocio departamentoNegocio;
	
	@GetMapping
	public List<Departamento> listado() {
		return this.departamentoNegocio.listado();
	}
}
