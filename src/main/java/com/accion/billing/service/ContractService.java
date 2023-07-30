package com.accion.billing.service;

import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.contract.ContractDTO;
import com.accion.billing.models.dto.contract.CreateOrUpdateContractDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ContractService {
    PageDTO<List<ContractDTO>> getContracts(Pageable pageable);
    Optional<ContractDTO> getContractById(BigInteger contractId);
    ContractDTO createOrUpdateContract(CreateOrUpdateContractDTO contract);
    void deleteContractById(BigInteger contractId);
}
