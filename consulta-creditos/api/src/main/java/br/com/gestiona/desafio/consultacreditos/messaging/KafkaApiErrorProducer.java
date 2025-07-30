package br.com.gestiona.desafio.consultacreditos.messaging;

import static br.com.gestiona.desafio.consultacreditos.messaging.MessageConstants.CONSULTA_CREDITO_ERRORS;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaApiErrorProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    /**
     * Envia uma mensagem de erro para o t pico "consulta-credito-errors".
     *
     * @param errorDto DTO do erro
     */
    public void sendError(Object errorDto) {
        try {
            String message = objectMapper.writeValueAsString(errorDto);
            kafkaTemplate.send(CONSULTA_CREDITO_ERRORS, message).get(5, java.util.concurrent.TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Erro ao enviar mensagem para o Kafka: {}", e.getMessage()); // Log/Handle error
        }
    }
}
