package com.accion.billing.models.mapper;

import com.accion.billing.entities.PayerNoteEntity;
import com.accion.billing.models.dto.payer.PayerNoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PayerNotesMapper extends EntityMapper<PayerNoteEntity, PayerNoteDTO> {
    @Mapping(target = "payer", ignore = true)
    PayerNoteEntity toEntity(PayerNoteDTO dto);
}
