package com.diego.sqs.api.exception;

import com.diego.sqs.infrastructure.annotation.BusinessException;
import org.springframework.http.HttpStatus;

@BusinessException(key = "recurso.informacao-conflitante", status = HttpStatus.CONFLICT, returnMessageException = true)
public class InformacaoConflitanteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InformacaoConflitanteException(String message) {
        super(message);
    }
}