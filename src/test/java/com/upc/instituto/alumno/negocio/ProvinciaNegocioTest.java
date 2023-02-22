package com.upc.instituto.alumno.negocio;

import com.upc.instituto.alumno.entidades.Provincia;
import com.upc.instituto.alumno.repositorio.IAlumnoRepositorio;
import com.upc.instituto.alumno.repositorio.IProvinciaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class ProvinciaNegocioTest {
    @Autowired
    private IProvinciaNegocio provinciaNegocio;

    @MockBean
    private IProvinciaRepositorio provinciaRepositorio;

    @Test
    void testListado() {
        List<Provincia> mockListaProvincia = Stream.of(
                new Provincia(1L, "Lima"),
                new Provincia(2L, "Piura")
        ).collect(Collectors.toList());

        Mockito.when(this.provinciaRepositorio.findAll()).thenReturn(mockListaProvincia);

        List<Provincia> listaProvincia = this.provinciaNegocio.listado();

        Assertions.assertEquals(listaProvincia, mockListaProvincia);
    }
}
