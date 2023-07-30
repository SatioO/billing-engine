package com.accion.billing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "payers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE payers SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class PayerEntity {
    @Id
    private BigInteger id;
    private String code;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String zipExtension;
    private BigInteger phone;
    private BigInteger fax;
    @Column(columnDefinition = "BPCHAR")
    private String rediCode;
    private String payorId;
    @Column(columnDefinition = "BPCHAR")
    private String revenueType;
    private boolean omitServiceSegment;
    private boolean invDosSort;
    private BigInteger termsNetDays;

    private BigInteger xray;
    private BigInteger ultrasound;
    private BigInteger doppler;
    private BigInteger addXray; 
    private BigInteger addUltrasound;
    private BigInteger dryRun;
    private BigInteger ekg;
    private BigInteger employee;
    private BigInteger va;
    private BigInteger ppd;
    private BigInteger stat;
    private BigInteger pctOfMcr;
    private String mcr2ndId;

    private boolean excludeXrSetup;
    private boolean excludeXrTrans;
    private boolean excludeUsSetup;
    private boolean excludeUsTrans;
    private boolean useTcFee;
    private boolean lookupSchedule;
    private boolean afterHours;
    private boolean groupTransport;
    private boolean excludeTcClm;
    private boolean excludeProfClm;

    private String clearinghouseCode;
    
    private boolean deleted;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
