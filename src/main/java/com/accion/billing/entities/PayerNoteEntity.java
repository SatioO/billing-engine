package com.accion.billing.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String text;
    private String invoiceText;

    @OneToOne
    @JoinColumn(name = "payer_id")
    private PayerEntity payer;
}
