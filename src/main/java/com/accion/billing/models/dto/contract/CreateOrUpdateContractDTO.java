package com.accion.billing.models.dto.contract;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigInteger;
import java.time.LocalDate;

public record CreateOrUpdateContractDTO(

        @NotNull BigInteger id,
        @Size(max = 40)
        String name,
        LocalDate effectiveFrom,
        LocalDate effectiveThru,
        boolean invoiceDiscount
) { }
