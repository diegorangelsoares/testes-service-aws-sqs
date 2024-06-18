package com.diego.sqs.infrastructure.exception;

import com.diego.sqs.infrastructure.annotation.BusinessException;
import org.springframework.http.HttpStatus;

@BusinessException(key = "liquibase.operacao-invalida", status = HttpStatus.NOT_FOUND, returnMessageException = true)
public class LiquibaseCustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LiquibaseCustomException(String message) {
        super(message);
    }
}
