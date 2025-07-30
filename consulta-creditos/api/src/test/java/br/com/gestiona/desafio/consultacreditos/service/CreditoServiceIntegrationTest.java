package br.com.gestiona.desafio.consultacreditos.service;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import br.com.gestiona.desafio.consultacreditos.config.ConsultaCreditosTestcontainersConfiguration;
import br.com.gestiona.desafio.consultacreditos.messaging.MessageConstants;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ConsultaCreditosTestcontainersConfiguration.class)
@SqlGroup({
        @Sql(scripts = "/fixtures/sql/setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS),
        @Sql(scripts = "/fixtures/sql/consulta-credito/consulta-credito.reset.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS),
        @Sql(scripts = "/fixtures/sql/consulta-credito/consulta-credito.data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
})
public class CreditoServiceIntegrationTest extends BaseTestService {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() throws ExecutionException, InterruptedException {
        deleteMessagesFromTopic(MessageConstants.CONSULTA_CREDITO);
    }

    @Nested
    @DisplayName("Buscar Créditos")
    class BuscarCreditos {

        @Nested
        @DisplayName("GET /api/creditos/{numeroNfse}")
        class ListByNfse {

            @Test
            void testBuscarCreditosByNfse() {
                ResponseEntity<String> response = restTemplate.withBasicAuth("guest", "guest")
                        .getForEntity("/api/creditos/7891011", String.class);
                Assertions.assertEquals(200, response.getStatusCodeValue());
                Assertions.assertNotNull(response.getBody());

                try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getKafkaConsumerProperties())) {
                    consumer.subscribe(Collections.singletonList(MessageConstants.CONSULTA_CREDITO));
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(2));
                    Assertions.assertFalse(records.isEmpty(), "Nenhuma mensagem encontrada no tópico consulta-credito");
                    logRecordMessages(records);
                }
            }
        }

        @Nested
        @DisplayName("GET /api/creditos/credito/{numeroCredito}")
        class GetByNumeroCredito {

            @Test
            void testBuscarCreditos() {
                ResponseEntity<String> response = restTemplate.withBasicAuth("guest", "guest")
                        .getForEntity("/api/creditos/credito/123456", String.class);
                Assertions.assertEquals(200, response.getStatusCodeValue());
                Assertions.assertNotNull(response.getBody());

                try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getKafkaConsumerProperties())) {
                    consumer.subscribe(Collections.singletonList(MessageConstants.CONSULTA_CREDITO));
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(2));
                    Assertions.assertFalse(records.isEmpty(), "Nenhuma mensagem encontrada no tópico consulta-credito");
                    logRecordMessages(records);
                }
            }
        }


        private void logRecordMessages(ConsumerRecords<String, String> records) {
            records.forEach(record -> log.info("Mensagem encontrada no tópico consulta-credito: {} - {}", record.key(), record.value()));
        }

    }

    @Nested
    @DisplayName("Autenticação")
    class Authentication {


        @Nested
        @DisplayName("Sucesso")
        class Success {

            @Nested
            @DisplayName("Autenticação com usuario e senha válidos")
            class AuthenticationWithValidUserAndPass {
                @Test
                void testAuthenticationWithValidUser() {
                    ResponseEntity<String> response = restTemplate.withBasicAuth("guest", "guest")
                            .getForEntity("/api/creditos/7891011", String.class);
                    Assertions.assertNotEquals(401, response.getStatusCode().value(), "Deveria retornar diferente de 401 para usuário/senha válidos");
                }
            }
        }


        @Nested
        @DisplayName("Failure")
        class Failure {

            @Nested
            @DisplayName("Autenticação com usuario e senha inválidos")
            class AuthenticationWithWrongUserAndPass {
                @Test
                void testAuthenticationWithWrongUser() {
                    ResponseEntity<String> response = restTemplate.withBasicAuth("wronguser", "wrongpass")
                            .getForEntity("/api/creditos/7891011", String.class);
                    Assertions.assertEquals(401, response.getStatusCode().value(), "Deveria retornar 401 para usuário/senha inválidos");
                }
            }

        }


    }


}
