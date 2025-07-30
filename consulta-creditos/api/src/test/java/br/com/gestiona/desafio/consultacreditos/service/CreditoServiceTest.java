package br.com.gestiona.desafio.consultacreditos.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.com.gestiona.desafio.consultacreditos.domain.dto.CreditoDTO;
import br.com.gestiona.desafio.consultacreditos.domain.jpa.Credito;
import br.com.gestiona.desafio.consultacreditos.exceptions.BusinessException;
import br.com.gestiona.desafio.consultacreditos.messaging.KafkaCreditoProducer;
import br.com.gestiona.desafio.consultacreditos.repository.jpa.CreditoRepository;


/**
 * Teste simples com JUnit e Mockito
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private KafkaCreditoProducer kafkaCreditoProducer; // evitar npe no teste ao chamar o service

    @InjectMocks
    private CreditoService creditoService;

    @Test
    public void testBuscarCreditoPorNumero() throws BusinessException {
        Credito creditoMock = new Credito();
        creditoMock.setNumeroCredito("123456");
        Mockito.when(creditoRepository.findByNumeroCredito("123456")).thenReturn(Optional.of(creditoMock));

        CreditoDTO creditoDTOMock = new CreditoDTO();
        creditoDTOMock.setNumeroCredito("123456");
        Mockito.when(modelMapper.map(Mockito.any(Credito.class), Mockito.eq(CreditoDTO.class))).thenReturn(creditoDTOMock);

        CreditoDTO resultado = creditoService.buscarPorNumeroCredito("123456");

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("123456", resultado.getNumeroCredito());
    }
}
