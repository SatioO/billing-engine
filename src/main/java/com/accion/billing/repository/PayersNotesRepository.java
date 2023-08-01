package com.accion.billing.repository;

import com.accion.billing.entities.PayerNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayersNotesRepository extends JpaRepository<PayerNoteEntity, Integer> {
}
