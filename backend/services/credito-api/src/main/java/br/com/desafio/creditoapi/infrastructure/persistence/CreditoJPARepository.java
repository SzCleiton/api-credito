package br.com.desafio.creditoapi.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CreditoJPARepository extends JpaRepository<CreditoJPAEntity, Long> {

    List<CreditoJPAEntity> findByNumeroNfse(String numeroNfse);

    Optional<CreditoJPAEntity> findByNumeroCredito(String numeroCredito);
}
