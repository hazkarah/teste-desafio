package br.com.gestiona.desafio.consultacreditos.service;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.testcontainers.kafka.KafkaContainer;

import br.com.gestiona.desafio.consultacreditos.messaging.MessageConstants;

@Service
public class BaseTestService {

    @Autowired
    protected KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Autowired
    private KafkaContainer kafkaContainer;

    protected String defaultUsername = "guest";
    protected String defaultPassword = "guest";

    public void deleteMessagesFromTopic(String topic) throws ExecutionException, InterruptedException {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getKafkaConsumerProperties())) {
            consumer.subscribe(Collections.singletonList(MessageConstants.CONSULTA_CREDITO));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(2));
            // NOOP, apenas consome as mensagens para limpar o tópico
        }

    }

    public Properties getKafkaConsumerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaContainer.getBootstrapServers());
        props.put("group.id", consumerGroupId);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");
        return props;
    }
}
