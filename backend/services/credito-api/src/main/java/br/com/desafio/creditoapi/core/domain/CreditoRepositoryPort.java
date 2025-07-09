package br.com.desafio.creditoapi.core.domain;

import java.util.List;
import java.util.Optional;

public interface CreditoRepositoryPort {
    List<Credito> findByNumeroNfse(String numeroNfse);
    Optional<Credito> findByNumeroCredito(String numeroCredito);
}
