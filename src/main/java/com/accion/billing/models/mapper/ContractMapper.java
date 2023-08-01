package com.accion.billing.models.mapper;

import com.accion.billing.entities.ContractEntity;
import com.accion.billing.models.dto.contract.ContractDTO;
import com.accion.billing.models.dto.contract.CreateOrUpdateContractDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContractMapper extends EntityMapper<ContractEntity, ContractDTO> {
    @Mapping(target = "payers", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ContractEntity toEntity(ContractDTO model);

    @Mapping(target = "payers", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ContractEntity createContractDtoToContractEntity(CreateOrUpdateContractDTO dto);
}
