package br.com.gestiona.desafio.consultacreditos.domain.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

import br.com.gestiona.desafio.consultacreditos.domain.DomainConstants;

@Data
@Entity
@Table(name = "credito", schema = DomainConstants.CREDITOS_SCHEMA)
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_credito", length = 50, nullable = false)
    private String numeroCredito;

    @Column(name = "numero_nfse", length = 50, nullable = false)
    private String numeroNfse;

    @Column(name = "data_constituicao", nullable = false)
    private LocalDate dataConstituicao;

    @Column(name = "valor_issqn", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorIssqn;

    @Column(name = "tipo_credito", length = 50, nullable = false)
    private String tipoCredito;

    @Column(name = "simples_nacional", nullable = false)
    private boolean simplesNacional;

    @Column(name = "aliquota", precision = 5, scale = 2, nullable = false)
    private BigDecimal aliquota;

    @Column(name = "valor_faturado", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorFaturado;

    @Column(name = "valor_deducao", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorDeducao;

    @Column(name = "base_calculo", precision = 15, scale = 2, nullable = false)
    private BigDecimal baseCalculo;
}
