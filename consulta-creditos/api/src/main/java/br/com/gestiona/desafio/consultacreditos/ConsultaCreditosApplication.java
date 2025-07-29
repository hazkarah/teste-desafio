package br.com.gestiona.desafio.consultacreditos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"br.com.gestiona.desafio.consultacreditos.repository.jpa"})
public class ConsultaCreditosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultaCreditosApplication.class, args);
    }

}
