package com.dev.paises;

import com.dev.paises.repositorio.PaisRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisesApplication.class, args);
	}       
      
}
