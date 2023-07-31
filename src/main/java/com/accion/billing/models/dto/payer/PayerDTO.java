package com.accion.billing.models.dto.payer;

import com.accion.billing.models.dto.contract.ContractDTO;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record PayerDTO(
    String id,
    String code,
    String name,
    String address1,
    String address2,
    String city,
    String state,
    String zip,
    String zipExtension,
    int phone,
    int fax,
    String rediCode,
    String payorId,
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

    String clearinghouseCode,

    LocalDateTime createdAt,
    LocalDateTime updatedAt,

    List<ContractDTO> contracts
){
    public PayerDTO {
        if(contracts == null) {
            contracts = new ArrayList<>();
        }
    }
}
