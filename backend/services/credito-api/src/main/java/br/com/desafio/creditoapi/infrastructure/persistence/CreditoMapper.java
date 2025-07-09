package br.com.desafio.creditoapi.infrastructure.persistence;

import br.com.desafio.creditoapi.core.domain.Credito;
import org.springframework.stereotype.Component;

@Component
public class CreditoMapper {

    public Credito toDomain(CreditoJPAEntity entity) {
        if (entity == null) return null;
        return Credito.builder()
                .id(entity.getId())
                .numeroCredito(entity.getNumeroCredito())
                .numeroNfse(entity.getNumeroNfse())
                .dataConstituicao(entity.getDataConstituicao())
                .valorIssqn(entity.getValorIssqn())
                .tipoCredito(entity.getTipoCredito())
                .simplesNacional(entity.isSimplesNacional())
                .aliquota(entity.getAliquota())
                .valorFaturado(entity.getValorFaturado())
                .valorDeducao(entity.getValorDeducao())
                .baseCalculo(entity.getBaseCalculo())
                .build();
    }
}
