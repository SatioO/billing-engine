package com.accion.billing.controllers;

import com.accion.billing.exceptions.ContractNotFoundException;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.contract.ContractDTO;
import com.accion.billing.models.dto.contract.CreateOrUpdateContractDTO;
import com.accion.billing.service.ContractService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/contracts")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<PageDTO<List<ContractDTO>>> getContracts(Pageable pageable) {
        PageDTO<List<ContractDTO>> foundContracts = contractService.getContracts(pageable);
        return ResponseEntity.ok().body(foundContracts);
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable() BigInteger contractId) {
        Optional<ContractDTO> foundContract = contractService.getContractById(contractId);

        return foundContract
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ContractNotFoundException(contractId));
    }

    @PutMapping
    public ResponseEntity<ContractDTO> createOrUpdateContract(@Valid @RequestBody CreateOrUpdateContractDTO body) {
        ContractDTO contract = contractService.createOrUpdateContract(body);
        return ResponseEntity.ok().body(contract);
    }

    @DeleteMapping("/{contractId}")
    public ResponseEntity<Void> deleteContract(@PathVariable BigInteger contractId) {
        contractService.deleteContractById(contractId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
