package br.com.gestiona.desafio.consultacreditos.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import br.com.gestiona.desafio.consultacreditos.domain.dto.CreditoDTO;
import br.com.gestiona.desafio.consultacreditos.domain.jpa.Credito;
import br.com.gestiona.desafio.consultacreditos.repository.jpa.CreditoRepository;

@RestController
@RequestMapping("/api/creditos")
@Tag(name = "Créditos", description = "Consulta creditos")
public class CreditoController {

    @Autowired
    private CreditoRepository creditoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Consulta por número da NFSe")
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<CreditoDTO> getCreditoPorNfse(@PathVariable String numeroNfse) {
        Credito credito = creditoRepository.findByNumeroNfse(numeroNfse);
        if (credito == null) {
            return ResponseEntity.notFound().build();
        }
        CreditoDTO dto = modelMapper.map(credito, CreditoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Consulta por número do crédito")
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> getCreditoPorNumero(@PathVariable String numeroCredito) {
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito);
        if (credito == null) {
            return ResponseEntity.notFound().build();
        }
        CreditoDTO dto = modelMapper.map(credito, CreditoDTO.class);
        return ResponseEntity.ok(dto);
    }
}

