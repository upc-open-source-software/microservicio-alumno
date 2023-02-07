package com.upc.instituto.alumno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.instituto.alumno.entidades.Departamento;

public interface IDepartamentoRepositorio extends JpaRepository<Departamento, Long> {

}
