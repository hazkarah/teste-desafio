package br.com.gestiona.desafio.consultacreditos.service;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gestiona.desafio.consultacreditos.domain.dto.CreditoDTO;
import br.com.gestiona.desafio.consultacreditos.domain.jpa.Credito;
import br.com.gestiona.desafio.consultacreditos.exceptions.BusinessException;
import br.com.gestiona.desafio.consultacreditos.repository.jpa.CreditoRepository;
import br.com.gestiona.desafio.consultacreditos.service.adapters.CreditoServiceAdapter;

@Service
@RequiredArgsConstructor
public class CreditoService implements CreditoServiceAdapter {

    private final CreditoRepository creditoRepository;
    private final ModelMapper modelMapper;

    public Page<CreditoDTO> buscarPorNumeroNfse(String numeroNfse, Pageable pageable) throws BusinessException {
        Page<Credito> page = creditoRepository.findByNumeroNfse(numeroNfse, pageable)
                .orElseThrow(() -> new BusinessException(String.format("Credito nao encontrado pelo numero da nfse: %s", numeroNfse), "credito.nao.encontrado"));

        return new PageImpl<>(page.getContent().stream().map(credito -> modelMapper.map(credito, CreditoDTO.class))
                .toList(), pageable, page.getTotalElements());
    }
    public CreditoDTO buscarPorNumeroCredito(String numeroCredito) throws BusinessException {
        return creditoRepository.findByNumeroCredito(numeroCredito)
                .map(credito -> modelMapper.map(credito, CreditoDTO.class))
                .orElseThrow(() -> new BusinessException(String.format("Credito nao encontrado pelo numero do credito: %s", numeroCredito), "credito.nao.encontrado"));
    }
}

