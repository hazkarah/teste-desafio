package br.com.gestiona.desafio.consultacreditos.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends Throwable {

    private final String code;
    private final String message;

    public BusinessException(String message, String code) {
        this.code = code;
        this.message = message;
    }
}
