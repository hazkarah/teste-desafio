package br.com.gestiona.desafio.consultacreditos;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"br.com.gestiona.desafio.consultacreditos.repository.jpa"})
public class ConsultaCreditosApplication {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${project.version:0.0.1-SNAPSHOT}")
    private String appVersion;

    @PostConstruct
    public void printVersionInfo() {
        System.out.println("\n==============================");
        System.out.println("Aplicação: " + appName);
        System.out.println("Versão: " + appVersion);
        System.out.println("==============================\n");
    }

    public static void main(String[] args) {

        SpringApplication.run(ConsultaCreditosApplication.class, args);
    }

}
