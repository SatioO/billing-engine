package com.accion.billing.models.dto.payer;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record CreateOrUpdatePayerDTO(
        @NotNull
        String id,
        String code,
        @NotNull
        String name,
        String address1,
        String address2,
        @NotNull
        String city,
        @NotNull
        String state,
        String zip,
        String zipExtension,
        int phone,
        int fax,
        @NotNull
        String rediCode,
        @NotNull
        String payorId,
        @NotNull
        String revenueType,
        boolean omitServiceSegment,
        boolean invDosSort,
        int termsNetDays,

        BigInteger xray,
        BigInteger ultrasound,
        BigInteger doppler,
        BigInteger addXray,
        BigInteger addUltrasound,
        BigInteger dryRun,
        BigInteger ekg,
        BigInteger employee,
        BigInteger va,
        BigInteger ppd,
        BigInteger stat,
        int pctOfMcr,
        String mcr2ndId,

        boolean excludeXrSetup,
        boolean excludeXrTrans,
        boolean excludeUsSetup,
        boolean excludeUsTrans,
        boolean useTcFee,
        boolean lookupSchedule,
        boolean afterHours,
        boolean groupTransport,
        boolean excludeTcClm,
        boolean excludeProfClm,

        String clearinghouseCode
){}

