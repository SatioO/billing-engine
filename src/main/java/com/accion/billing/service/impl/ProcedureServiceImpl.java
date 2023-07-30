package com.accion.billing.service.impl;

import com.accion.billing.entities.ProcedureEntity;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.common.PageMetaDTO;
import com.accion.billing.models.dto.procedure.CreateOrUpdateProcedureDTO;
import com.accion.billing.models.dto.procedure.ProcedureDTO;
import com.accion.billing.models.mapper.ProcedureMapper;
import com.accion.billing.repository.ProcedureRepository;
import com.accion.billing.service.ProcedureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepository procedureRepository;
    private final ProcedureMapper mapper;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository, ProcedureMapper mapper) {
        this.procedureRepository = procedureRepository;
        this.mapper = mapper;
    }

    @Override
    public PageDTO<List<ProcedureDTO>> getProcedures(Pageable pageable) {
        Page<ProcedureEntity> foundProcedures = procedureRepository.findAll(pageable);
        return new PageDTO<>(
                foundProcedures.stream().map(mapper::toModel).collect(Collectors.toList()),
                new PageMetaDTO<>(foundProcedures)
        );
    }

    @Override
    public Optional<ProcedureDTO> getProcedureByCode(String code) {
        Optional<ProcedureEntity> foundProcedure = procedureRepository.findById(code);
        return foundProcedure.map(mapper::toModel);
    }

    @Override
    public ProcedureDTO createOrUpdateProcedure(CreateOrUpdateProcedureDTO body) {
        ProcedureEntity mappedProcedure = mapper.createOrUpdateProcedureDTOToProcedureEntity(body);
        ProcedureEntity procedure = procedureRepository.save(mappedProcedure);
        return mapper.toModel(procedure);
    }

    @Override
    public void deleteProcedureByCode(String code) {
        Optional<ProcedureEntity> foundProcedure = procedureRepository.findById(code);

        if(foundProcedure.isPresent()) {
            procedureRepository.deleteById(code);
        }
    }
}
