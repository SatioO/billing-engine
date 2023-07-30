package com.accion.billing.models.dto.procedure;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CreateOrUpdateProcedureDTO(
        @NotNull
        @Size(max = 10)
        String code,
        @NotNull
        @Size(max = 40)
        String description,
        BigDecimal globalFee,
        BigDecimal technicalFee,
        BigDecimal professionalFee,
        BigDecimal cost,
        BigDecimal defaultUnits,
        String defaultModifier,
        String tosCode,
        String posCode,
        @NotNull
        @Size(max = 1)
        String modality
){
        public CreateOrUpdateProcedureDTO {
                if(globalFee == null) globalFee = BigDecimal.ZERO;
                if(technicalFee == null) technicalFee = BigDecimal.ZERO;
                if(professionalFee == null) professionalFee = BigDecimal.ZERO;
                if(cost == null) cost = BigDecimal.valueOf(1.00);
        }
}