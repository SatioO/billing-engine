package com.accion.billing.service.impl;

import com.accion.billing.entities.ContractEntity;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.common.PageMetaDTO;
import com.accion.billing.models.dto.contract.ContractDTO;
import com.accion.billing.models.dto.contract.CreateOrUpdateContractDTO;
import com.accion.billing.models.mapper.ContractMapper;
import com.accion.billing.repository.ContractRepository;
import com.accion.billing.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper mapper;

    public ContractServiceImpl(ContractRepository contractRepository, ContractMapper mapper) {
        this.contractRepository = contractRepository;
        this.mapper = mapper;
    }

    public PageDTO<List<ContractDTO>> getContracts(Pageable pageable) {
        Page<ContractEntity> foundContracts = contractRepository.findAll(pageable);

        return new PageDTO<>(
            foundContracts.stream().map(mapper::toModel).collect(Collectors.toList()),
            new PageMetaDTO<>(foundContracts)
        );
    }

    public Optional<ContractDTO> getContractById(BigInteger contractId) {
        Optional<ContractEntity> foundContract = contractRepository.findById(contractId);
        return foundContract.map(mapper::toModel);
    }

    public ContractDTO createOrUpdateContract(CreateOrUpdateContractDTO body) {
        ContractEntity mappedContract = mapper.createContractDtoToContractEntity(body);
        ContractEntity contract = contractRepository.save(mappedContract);
        return mapper.toModel(contract);
    }

    public void deleteContractById(BigInteger contractId) {
        Optional<ContractEntity> foundContract = contractRepository.findById(contractId);

        if(foundContract.isPresent()) {
            contractRepository.deleteById(contractId);
        };
    }
}
