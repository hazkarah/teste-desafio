package br.com.gestiona.desafio.consultacreditos.exceptions;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gestiona.desafio.consultacreditos.domain.dto.base.ApiError;
import br.com.gestiona.desafio.consultacreditos.messaging.KafkaApiErrorProducer;

@RestControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler {

    private final KafkaApiErrorProducer kafkaApiErrorProducer;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException ex) {
        ApiError error = new ApiError(ex.getCode(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        kafkaApiErrorProducer.sendError(error);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof BusinessException) {
            return handleBusinessException((BusinessException) cause);
        }
        ApiError error = new ApiError("500", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        kafkaApiErrorProducer.sendError(error);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
