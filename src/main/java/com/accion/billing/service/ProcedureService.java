package com.accion.billing.service;

import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.procedure.CreateOrUpdateProcedureDTO;
import com.accion.billing.models.dto.procedure.ProcedureDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProcedureService {
    PageDTO<List<ProcedureDTO>> getProcedures(Pageable pageable);
    Optional<ProcedureDTO> getProcedureByCode(String code);
    ProcedureDTO createOrUpdateProcedure(CreateOrUpdateProcedureDTO procedure);
    void deleteProcedureByCode(String code);
}
