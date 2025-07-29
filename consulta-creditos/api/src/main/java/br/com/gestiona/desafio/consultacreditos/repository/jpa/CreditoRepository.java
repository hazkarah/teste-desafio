package br.com.gestiona.desafio.consultacreditos.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gestiona.desafio.consultacreditos.domain.jpa.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {

    @Query("SELECT c FROM Credito c WHERE c.numeroNfse = :numeroNfse")
    Credito findByNumeroNfse(String numeroNfse);

    @Query("SELECT c FROM Credito c WHERE c.numeroCredito = :numeroCredito")
    Credito findByNumeroCredito(String numeroCredito);
}
