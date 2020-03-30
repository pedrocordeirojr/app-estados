package com.appestados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String defaultMessage, String internalMessage, String code) {
        super(defaultMessage, internalMessage, code);
    }

    public BusinessException(String defaultMessage, String code) {
        super(defaultMessage, code);
    }
}
