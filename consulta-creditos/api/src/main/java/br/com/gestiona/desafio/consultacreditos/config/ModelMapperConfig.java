package br.com.gestiona.desafio.consultacreditos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // default
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

