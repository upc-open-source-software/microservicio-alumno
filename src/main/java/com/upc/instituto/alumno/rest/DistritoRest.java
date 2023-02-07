package com.upc.instituto.alumno.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upc.instituto.alumno.entidades.Distrito;
import com.upc.instituto.alumno.negocio.IDistritoNegocio;

@RestController
@RequestMapping("/api/distritos")
public class DistritoRest {
	@Autowired
	private IDistritoNegocio distritoNegocio;
	
	@GetMapping
	public List<Distrito> listado() {
		return this.distritoNegocio.listado();
	}
}
