package com.upc.instituto.alumno.negocio;

import com.upc.instituto.alumno.entidades.Departamento;
import com.upc.instituto.alumno.repositorio.IDepartamentoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartamentoNegocioTest {

    @Autowired
    private DepartamentoNegocio departamentoNegocio;

    @MockBean
    private IDepartamentoRepositorio departamentoRepositorio;

    @Test
    void testListado() {
        when(this.departamentoRepositorio.findAll()).thenReturn(Stream.of(
                new Departamento(1L, "Lima"),
                new Departamento(2L, "Piura")
        ).collect(Collectors.toList()));
        List<Departamento> listaDepartamento = this.departamentoNegocio.listado();
        Assertions.assertEquals(2, listaDepartamento.size());
    }

    @Test
    void testListado2() {
        List<Departamento> mockListaDepartamento = Stream.of(
                new Departamento(1L, "Lima"),
                new Departamento(2L, "Piura")
        ).collect(Collectors.toList());

        when(this.departamentoRepositorio.findAll()).thenReturn(mockListaDepartamento);

        List<Departamento> listaDepartamento = this.departamentoNegocio.listado();

        Assertions.assertEquals(listaDepartamento, mockListaDepartamento);
    }
}
