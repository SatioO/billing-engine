package com.accion.billing.repository;

import com.accion.billing.entities.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, String> {
}
