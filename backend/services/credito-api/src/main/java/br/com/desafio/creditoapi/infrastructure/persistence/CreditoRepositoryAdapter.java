package br.com.desafio.creditoapi.infrastructure.persistence;

import br.com.desafio.creditoapi.core.domain.Credito;
import br.com.desafio.creditoapi.core.domain.CreditoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreditoRepositoryAdapter implements CreditoRepositoryPort {

    private final CreditoJPARepository jpaRepository;
    private final CreditoMapper mapper;

    @Override
    public List<Credito> findByNumeroNfse(String numeroNfse) {
        return jpaRepository.findByNumeroNfse(numeroNfse).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Credito> findByNumeroCredito(String numeroCredito) {
        return jpaRepository.findByNumeroCredito(numeroCredito)
                .map(mapper::toDomain);
    }
}
