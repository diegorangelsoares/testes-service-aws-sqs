package com.diego.sqs.infrastructure.exception;


import com.diego.sqs.infrastructure.annotation.BusinessException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@BusinessException(key = "recurso.informacao-nao-encontrada-cliente", status = NOT_FOUND, returnMessageException = true)
public class InformacaoNaoEncontradaClientException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InformacaoNaoEncontradaClientException(String message) {
        super(message);
    }
}
