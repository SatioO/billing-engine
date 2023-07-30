package com.accion.billing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigInteger;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContractNotFoundException extends RuntimeException {
    public ContractNotFoundException(BigInteger contractId) {
        super("Contract with id: "+ contractId +" not found");
    }
}
