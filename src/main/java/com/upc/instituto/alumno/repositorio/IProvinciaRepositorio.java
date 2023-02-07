package com.upc.instituto.alumno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.instituto.alumno.entidades.Provincia;

public interface IProvinciaRepositorio extends JpaRepository<Provincia, Long> {

}
