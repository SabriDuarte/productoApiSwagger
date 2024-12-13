package com.example.ProductoApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Configura Spring Boot:
//@EnableJpaAuditing: Habilita auditoría de JPA.
//@EnableJpaRepositories: Escanea los repositorios.
//Ejecuta la aplicación con SpringApplication.run.
@SpringBootApplication(scanBasePackages = "com.universidad.productoapi") // Asegúrate de que todos los paquetes sean
																			// escaneados
@EnableJpaRepositories("com.universidad.productoapi.repository") // Asegúrate de que los repositorios sean escaneados
@EnableJpaAuditing // Asegúrate de habilitar la auditoría de JPA
public class ProductoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoApiApplication.class, args);
	}
}
