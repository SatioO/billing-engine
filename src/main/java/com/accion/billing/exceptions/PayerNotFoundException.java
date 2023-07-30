package com.accion.billing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigInteger;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PayerNotFoundException extends RuntimeException {
    public PayerNotFoundException(BigInteger payerId) {
        super("Payer with id: "+ payerId +" not found");
    }
}
