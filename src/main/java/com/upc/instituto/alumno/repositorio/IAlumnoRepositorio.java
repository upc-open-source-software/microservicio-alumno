package com.upc.instituto.alumno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.instituto.alumno.entidades.Alumno;

public interface IAlumnoRepositorio extends JpaRepository<Alumno, Long> {

}
