package com.diego.sqs.infrastructure.exception;



import com.diego.sqs.infrastructure.annotation.BusinessException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@BusinessException(key = "multitenancy.nao-conectar", status = BAD_REQUEST)
public class TenantNotConnectionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
