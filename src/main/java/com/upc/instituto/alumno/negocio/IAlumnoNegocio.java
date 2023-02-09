package com.upc.instituto.alumno.negocio;

import java.util.List;
import java.util.Optional;

import com.upc.instituto.alumno.entidades.Alumno;

public interface IAlumnoNegocio {
    public Alumno registrar(Alumno alumno);
    public Optional<Alumno> buscar(Long codigo);
    public List<Alumno> listado();
    public Alumno actualizar(Alumno alumno);
    public void eliminar(Long codigo);
}
