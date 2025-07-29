package br.com.gestiona.desafio.consultacreditos.service.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.gestiona.desafio.consultacreditos.domain.dto.CreditoDTO;
import br.com.gestiona.desafio.consultacreditos.exceptions.BusinessException;

public interface CreditoServiceAdapter {

    Page<CreditoDTO> buscarPorNumeroNfse(String numeroNfse, Pageable pageable) throws BusinessException;

    CreditoDTO buscarPorNumeroCredito(String numeroCredito) throws BusinessException;
}
