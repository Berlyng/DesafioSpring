package com.aluracursos.desafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.desafio.Principal.Principa;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Principa principal = new Principa();

		principal.mostrarMenu();

	}

}
