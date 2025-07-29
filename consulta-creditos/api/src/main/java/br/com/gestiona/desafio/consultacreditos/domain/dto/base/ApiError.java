package br.com.gestiona.desafio.consultacreditos.domain.dto.base;

import java.util.Map;

import lombok.Data;

@Data
public class ApiError {

    private final String code;
    private final String message;
    private final String debugMessage;
    private final String traceId;
    private final Map<String, String> errors;

    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
        this.debugMessage = "";
        this.traceId = "";
        this.errors = null;
    }

    public ApiError(String code, String message, String debugMessage, String traceId, Map<String, String> errors) {
        this.code = code;
        this.message = message;
        this.debugMessage = debugMessage;
        this.traceId = traceId;
        this.errors = errors;
    }

}

