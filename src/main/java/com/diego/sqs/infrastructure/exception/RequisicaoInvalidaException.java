package com.diego.sqs.infrastructure.exception;

import com.diego.sqs.infrastructure.annotation.BusinessException;
import org.springframework.http.HttpStatus;

@BusinessException(key = "recurso.requisicao-invalida", status = HttpStatus.BAD_REQUEST, returnMessageException = true)
public class RequisicaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequisicaoInvalidaException(String message) {
        super(message);
    }

}

