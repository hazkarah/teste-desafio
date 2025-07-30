package br.com.gestiona.desafio.consultacreditos.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaCreditoProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    /**
     * Envia uma mensagem de auditoria para o t pico especificado contendo o DTO do cr dito.
     *
     * @param topic   t pico do kafka para onde a mensagem ser  enviada
     * @param creditoDto   DTO do cr dito que ser  enviado na mensagem
     */
    public void enviaAuditoriaConsultaCredito(String topic, Object creditoDto) {
        try {
            String message = objectMapper.writeValueAsString(creditoDto);
            kafkaTemplate.send(topic, groupId, message).get(5, java.util.concurrent.TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Erro ao enviar mensagem para o Kafka: {}", e.getMessage());
        }
    }
}
