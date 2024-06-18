package com.diego.sqs.infrastructure.exception;



import com.diego.sqs.infrastructure.annotation.BusinessException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@BusinessException(key = "multitenancy.nao-encontrado", status = BAD_REQUEST)
public class TenantNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
