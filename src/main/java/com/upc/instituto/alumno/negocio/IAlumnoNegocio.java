package com.upc.instituto.alumno.negocio;

import java.util.List;

import com.upc.instituto.alumno.entidades.Alumno;

public interface IAlumnoNegocio {
    public Alumno registrar(Alumno alumno);
    public Alumno buscar(Long codigo) throws Exception;
    public List<Alumno> listado();
    public Alumno actualizar(Alumno alumno) throws Exception;

}
