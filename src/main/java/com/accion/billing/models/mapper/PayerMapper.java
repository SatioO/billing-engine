package com.accion.billing.models.mapper;

import com.accion.billing.entities.ContractEntity;
import com.accion.billing.entities.PayerEntity;
import com.accion.billing.entities.PayerNoteEntity;
import com.accion.billing.models.dto.contract.ContractDTO;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import com.accion.billing.models.dto.payer.PayerNoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PayerMapper extends EntityMapper<PayerEntity, PayerDTO> {
    @Mapping(target = "deleted", ignore = true)
    PayerEntity toEntity(PayerDTO dto);

    @Mapping(target = "contracts", ignore = true)
    @Mapping(target = "note", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    PayerEntity createOrUpdatePayerDtoToPayerEntity(CreateOrUpdatePayerDTO dto);

    default ContractEntity contractDtoToContractEntity(ContractDTO dto) {
        return Mappers.getMapper(ContractMapper.class).toEntity(dto);
    }

    default PayerNoteEntity payerNoteDtoToPayerNoteEntity(PayerNoteDTO dto) {
        return Mappers.getMapper(PayerNotesMapper.class).toEntity(dto);
    }
}
