package br.com.gestiona.desafio.consultacreditos.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import br.com.gestiona.desafio.consultacreditos.domain.dto.CreditoDTO;
import br.com.gestiona.desafio.consultacreditos.exceptions.BusinessException;
import br.com.gestiona.desafio.consultacreditos.service.adapters.CreditoServiceAdapter;

@RestController
@RequestMapping("/api/creditos")
@Tag(name = "Créditos", description = "Consulta creditos")
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoServiceAdapter creditoService;

    @Operation(summary = "Consulta por número da NFSe")
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDTO>> getCreditoPorNfse(@PathVariable String numeroNfse) throws BusinessException {
        return ResponseEntity.ok(creditoService.buscarPorNumeroNfse(numeroNfse, Pageable.unpaged()).getContent());
    }

    @Operation(summary = "Consulta por número do crédito")
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> getCreditoPorNumero(@PathVariable String numeroCredito) throws BusinessException {
        return ResponseEntity.ok(creditoService.buscarPorNumeroCredito(numeroCredito));
    }

    @Operation(summary = "Consulta paginada por número da NFSe")
    @GetMapping("/{numeroNfse}/page")
    public ResponseEntity<Page<CreditoDTO>> getPageCreditoPorNfse(@PathVariable String numeroNfse, Pageable pageable) throws BusinessException {
        return ResponseEntity.ok(creditoService.buscarPorNumeroNfse(numeroNfse, pageable));
    }

}

