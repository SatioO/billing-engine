package com.accion.billing.models.mapper;

import com.accion.billing.entities.ProcedureEntity;
import com.accion.billing.models.dto.procedure.CreateOrUpdateProcedureDTO;
import com.accion.billing.models.dto.procedure.ProcedureDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcedureMapper extends EntityMapper<ProcedureEntity, ProcedureDTO> {
    @Mapping(target = "deleted", ignore = true)
    ProcedureEntity toEntity(ProcedureDTO model);

    ProcedureDTO toModel(ProcedureEntity entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ProcedureEntity createOrUpdateProcedureDTOToProcedureEntity(CreateOrUpdateProcedureDTO dto);
}
