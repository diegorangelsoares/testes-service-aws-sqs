package com.diego.sqs.infrastructure.exception;


import com.diego.sqs.infrastructure.annotation.BusinessException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@BusinessException(key = "recurso.integracao.desconhecido", status = INTERNAL_SERVER_ERROR)
public class ErroDesconhecidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ErroDesconhecidoException(String message) {
		super(message);
	}
}
