package com.upc.instituto.alumno.negocio;

import com.upc.instituto.alumno.entidades.Distrito;
import com.upc.instituto.alumno.repositorio.IDistritoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class DistritoNegocioTest {
    @Autowired
    private IDistritoNegocio distritoNegocio;

    @MockBean
    private IDistritoRepositorio distritoRepositorio;

    @Test
    void testListado() {
        List<Distrito> mockListaDistrito = Stream.of(
            new Distrito(1L, "SJL"),
            new Distrito(2L, "San Isidro")
        ).collect(Collectors.toList());

        Mockito.when(this.distritoRepositorio.findAll()).thenReturn(mockListaDistrito);

        List<Distrito> listaDistrito = this.distritoNegocio.listado();

        Assertions.assertEquals(listaDistrito, mockListaDistrito);
    }
}
