package com.accion.billing.models.mapper;

import com.accion.billing.entities.PayerEntity;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PayerMapper extends EntityMapper<PayerEntity, PayerDTO> {
    @Override
    @Mapping(target = "deleted", ignore = true)
    PayerEntity toEntity(PayerDTO dto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    PayerEntity createOrUpdatePayerDtoToPayerEntity(CreateOrUpdatePayerDTO dto);
}
