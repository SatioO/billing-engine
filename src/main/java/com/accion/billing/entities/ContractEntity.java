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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE contracts SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class ContractEntity {
    @Id
    private BigInteger id;

    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate effectiveFrom;

    @Column(columnDefinition = "DATE")
    private LocalDate effectiveThru;

    private boolean invoiceDiscount;

    @Builder.Default
    private boolean deleted = false;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
