package com.upc.instituto.alumno.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upc.instituto.alumno.entidades.Distrito;
import com.upc.instituto.alumno.negocio.IDistritoNegocio;

@RestController
@RequestMapping("/api/distritos")
//@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST}, allowedHeaders = "*")
@CrossOrigin("*")
public class DistritoRest {
	@Autowired
	private IDistritoNegocio distritoNegocio;
	
	@GetMapping
	public List<Distrito> listado() {
		return this.distritoNegocio.listado();
	}
}
