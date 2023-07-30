package com.accion.billing.models.dto.contract;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;


public record ContractDTO(
        BigInteger id,
        String name,
        LocalDate effectiveFrom,
        LocalDate effectiveThru,
        boolean invoiceDiscount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
