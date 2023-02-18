package com.upc.instituto.alumno.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.upc.instituto.alumno.entidades.Alumno;
import com.upc.instituto.alumno.repositorio.IAlumnoRepositorio;

import static org.mockito.Mockito.*;

@SpringBootTest
public class AlumnoNegocioTest {

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private IAlumnoNegocio alumnoNegocio;

	@MockBean
	private IAlumnoRepositorio alumnoRepositorio;

	@Test
	void testListado() throws Exception {
		when(this.alumnoRepositorio.findAll()).thenReturn(Stream.of(
				new Alumno(1L, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
						"luisguisado@email.com", 1L, 1L, 1L, new Date()),
				new Alumno(2L, "Diego", "Bravo", format.parse("1996-12-05"), "Avenida Miraflores", "966345124",
						"diegobravo@email.com", 1L, 1L, 1L, new Date()))
				.collect(Collectors.toList()));
		Assertions.assertEquals(2, this.alumnoNegocio.listado().size());
	}

	@Test
	void testRegistrar() throws Exception {
		Alumno alumno = new Alumno(null, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
				"luisguisado@email.com", 1L, 1L, 1L, new Date());
		Alumno alumno2 = new Alumno(1L, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
				"luisguisado@email.com", 1L, 1L, 1L, new Date());
		when(this.alumnoRepositorio.save(alumno)).thenReturn(alumno2);
		Alumno alumnoResultado = this.alumnoNegocio.registrar(alumno);
		Assertions.assertEquals(alumno2, alumnoResultado);
	}

	@Test
	void testBuscar() throws Exception {
		Long codigo = 1L;
		Alumno alumno1 = new Alumno(1L, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
				"luisguisado@email.com", 1L, 1L, 1L, new Date());
		Optional<Alumno> optionalAlumno1 = Optional.of(alumno1);
		when(this.alumnoRepositorio.findById(codigo)).thenReturn(optionalAlumno1);
		Optional<Alumno> alumnoResultado = this.alumnoNegocio.buscar(1L);
		Assertions.assertEquals(optionalAlumno1, alumnoResultado);
	}

	@Test
	void testActualizar() throws Exception {
		Alumno alumno = new Alumno(1L, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
				"luisguisado@email.com", 1L, 1L, 1L, new Date());
		when(this.alumnoRepositorio.save(alumno)).thenReturn(alumno);
		Assertions.assertEquals(alumno, this.alumnoNegocio.actualizar(alumno));
	}

	@Test
	void Eliminar() throws Exception {
		Alumno alumno = new Alumno(1L, "Luis", "Guisado", format.parse("1995-11-11"), "Avenida Perú 123", "966345121",
				"luisguisado@email.com", 1L, 1L, 1L, new Date());
		Long codigo = 1L;
		this.alumnoNegocio.eliminar(codigo);
		verify(this.alumnoRepositorio, times(1)).deleteById(codigo);
	}
}
