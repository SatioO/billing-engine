package com.accion.billing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProcedureNotFoundException extends RuntimeException {
    public ProcedureNotFoundException(String code) {
        super("Procedure with code: "+ code +" not found");
    }
}
