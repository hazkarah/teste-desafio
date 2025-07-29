package br.com.gestiona.desafio.consultacreditos.repository.jpa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gestiona.desafio.consultacreditos.domain.jpa.Credito;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {

    @Query("SELECT c FROM Credito c WHERE c.numeroNfse = :numeroNfse")
    Optional<Page<Credito>> findByNumeroNfse(String numeroNfse, Pageable pageable);

    @Query("SELECT c FROM Credito c WHERE c.numeroCredito = :numeroCredito")
    Optional<Credito> findByNumeroCredito(String numeroCredito);
}
