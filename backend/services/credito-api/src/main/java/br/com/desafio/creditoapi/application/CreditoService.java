package br.com.desafio.creditoapi.application;

import br.com.desafio.creditoapi.application.exception.ResourceNotFoundException;
import br.com.desafio.creditoapi.core.domain.Credito;
import br.com.desafio.creditoapi.core.domain.CreditoRepositoryPort;
import br.com.desafio.creditoapi.infrastructure.messaging.AuditServiceKafkaProducer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreditoService {

    private final CreditoRepositoryPort creditoRepositoryPort;
    private final AuditServiceKafkaProducer auditProducer;

    public CreditoService(CreditoRepositoryPort creditoRepositoryPort, AuditServiceKafkaProducer auditProducer) {
        this.creditoRepositoryPort = creditoRepositoryPort;
        this.auditProducer = auditProducer;
    }

    public List<Credito> findByNumeroNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepositoryPort.findByNumeroNfse(numeroNfse);
        String auditMessage = String.format("Consulta por NFS-e: %s. Resultado: %d registro(s).", numeroNfse, creditos.size());
        auditProducer.sendMessage(auditMessage);
        return creditos;
    }

    public Credito findByNumeroCredito(String numeroCredito) {
        Credito credito = creditoRepositoryPort.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new ResourceNotFoundException("Crédito não encontrado com o número: " + numeroCredito));
        String auditMessage = String.format("Consulta por Crédito: %s. Resultado: Encontrado.", numeroCredito);
        auditProducer.sendMessage(auditMessage);
        return credito;
    }
}
