package br.com.desafio.creditoapi.adapters.in.web.dto;

import br.com.desafio.creditoapi.core.domain.Credito;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class CreditoResponseDTO {
    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private boolean simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    public static CreditoResponseDTO fromDomain(Credito domain) {
        return CreditoResponseDTO.builder()
                .numeroCredito(domain.getNumeroCredito())
                .numeroNfse(domain.getNumeroNfse())
                .dataConstituicao(domain.getDataConstituicao())
                .valorIssqn(domain.getValorIssqn())
                .tipoCredito(domain.getTipoCredito())
                .simplesNacional(domain.isSimplesNacional())
                .aliquota(domain.getAliquota())
                .valorFaturado(domain.getValorFaturado())
                .valorDeducao(domain.getValorDeducao())
                .baseCalculo(domain.getBaseCalculo())
                .build();
    }
}
