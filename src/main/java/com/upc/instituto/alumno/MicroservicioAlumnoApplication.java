package com.upc.instituto.alumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAlumnoApplication.class, args);
	}

}
