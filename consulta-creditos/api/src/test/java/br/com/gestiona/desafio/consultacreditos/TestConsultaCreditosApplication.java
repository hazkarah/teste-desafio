package br.com.gestiona.desafio.consultacreditos;

import org.springframework.boot.SpringApplication;

public class TestConsultaCreditosApplication {

	public static void main(String[] args) {
		SpringApplication.from(ConsultaCreditosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
