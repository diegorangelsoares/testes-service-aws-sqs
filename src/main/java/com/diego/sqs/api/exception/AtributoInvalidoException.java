package com.diego.sqs.api.exception;

import com.diego.sqs.infrastructure.annotation.BusinessException;
import org.springframework.http.HttpStatus;

@BusinessException(key = "recurso.atributo-invalido", status = HttpStatus.BAD_REQUEST, returnMessageException = true)
public class AtributoInvalidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AtributoInvalidoException(String message) {
        super(message);
    }
}
