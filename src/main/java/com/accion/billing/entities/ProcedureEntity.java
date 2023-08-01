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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "procedures")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE procedures SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class ProcedureEntity {
    @Id
    private String code;

    private String description;

    private BigDecimal globalFee;

    private BigDecimal technicalFee;

    private BigDecimal professionalFee;

    private BigDecimal cost;

    private BigDecimal defaultUnits;

    private String defaultModifier;

    @Column(columnDefinition = "BPCHAR(1)")
    private String tosCode;

    private String posCode;

    @Column(columnDefinition = "BPCHAR(1) NOT NULL")
    private String modality;

    @Builder.Default
    private boolean deleted = false;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
