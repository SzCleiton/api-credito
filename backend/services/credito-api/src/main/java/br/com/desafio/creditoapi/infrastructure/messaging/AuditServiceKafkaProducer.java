package br.com.desafio.creditoapi.infrastructure.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(AuditServiceKafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName;

    public AuditServiceKafkaProducer(KafkaTemplate<String, String> kafkaTemplate,
                                     @Value("${audit.topic}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(String message) {
        try {
            kafkaTemplate.send(topicName, message);
            logger.info("Mensagem de auditoria enviada para o tópico {}: {}", topicName, message);
        } catch (Exception e) {
            logger.error("Falha ao enviar mensagem para o Kafka: {}", e.getMessage(), e);
        }
    }
}
