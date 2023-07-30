package com.accion.billing.models.dto.procedure;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;


public record ProcedureDTO(
        String code,
        String description,
        BigDecimal globalFee,
        BigDecimal technicalFee,
        BigDecimal professionalFee,
        BigDecimal cost,
        BigDecimal defaultUnits,
        String defaultModifier,
        String tosCode,
        String posCode,
        String modality,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
