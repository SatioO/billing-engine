package com.accion.billing.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigInteger;

@Entity
@Table(name = "payers_notes")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayerNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String note;
    private String invoice;

    @OneToOne
    @JoinColumn(name = "payer_id")
    private PayerEntity payer;
}
