package com.accion.billing.controllers;

import com.accion.billing.exceptions.ProcedureNotFoundException;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.procedure.CreateOrUpdateProcedureDTO;
import com.accion.billing.models.dto.procedure.ProcedureDTO;
import com.accion.billing.service.ProcedureService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/procedures")
public class ProcedureController {
    private final ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @GetMapping
    public ResponseEntity<PageDTO<List<ProcedureDTO>>> getProcedures(Pageable pageable) {
        PageDTO<List<ProcedureDTO>> procedures = procedureService.getProcedures(pageable);
        return ResponseEntity.ok().body(procedures);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProcedureDTO> getProcedureById(@PathVariable String code) {
        Optional<ProcedureDTO> foundProcedure = procedureService.getProcedureByCode(code);
        return foundProcedure
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProcedureNotFoundException(code));
    }

    @PutMapping
    public ResponseEntity<ProcedureDTO> createOrUpdateProcedure(@Valid @RequestBody CreateOrUpdateProcedureDTO body) {
        ProcedureDTO procedure = procedureService.createOrUpdateProcedure(body);
        return ResponseEntity.ok().body(procedure);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteProcedureByCode(@PathVariable String code) {
        procedureService.deleteProcedureByCode(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
