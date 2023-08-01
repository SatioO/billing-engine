package com.accion.billing.service.impl;

import com.accion.billing.entities.ContractEntity;
import com.accion.billing.entities.PayerEntity;
import com.accion.billing.entities.PayerNoteEntity;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.common.PageMetaDTO;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import com.accion.billing.models.mapper.PayerMapper;
import com.accion.billing.models.mapper.PayerNotesMapper;
import com.accion.billing.repository.ContractRepository;
import com.accion.billing.repository.PayerRepository;
import com.accion.billing.repository.PayersNotesRepository;
import com.accion.billing.service.PayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PayerServiceImpl implements PayerService {
    private final PayerRepository payerRepository;
    private final ContractRepository contractRepository;
    private final PayersNotesRepository payersNotesRepository;
    private final PayerMapper payerMapper;
    private final PayerNotesMapper payerNotesMapper;

    public PayerServiceImpl(PayerRepository payerRepository, ContractRepository contractRepository, PayersNotesRepository payersNotesRepository, PayerMapper payerMapper, PayerNotesMapper payerNotesMapper) {
        this.payerRepository = payerRepository;
        this.contractRepository = contractRepository;
        this.payersNotesRepository = payersNotesRepository;
        this.payerMapper = payerMapper;
        this.payerNotesMapper = payerNotesMapper;
    }

    @Override
    public PageDTO<List<PayerDTO>> getPayers(Pageable pageable) {
        Page<PayerEntity> foundPayers = payerRepository.findAll(pageable);
        List<PayerDTO> payers = foundPayers.stream().map(payerMapper::toModel).collect(Collectors.toList());

        return new PageDTO<>(payers, new PageMetaDTO<>(foundPayers));
    }

    @Override
    public Optional<PayerDTO> getPayerById(BigInteger payerId) {
        Optional<PayerEntity> foundPayer = payerRepository.findById(payerId);
        return foundPayer.map(payerMapper::toModel);
    }

    @Override
    @Transactional
    public PayerDTO createOrUpdatePayer(CreateOrUpdatePayerDTO body) {
        List<ContractEntity> contracts = contractRepository.getContracts(body.contracts());
        PayerEntity mappedPayer = payerMapper.createOrUpdatePayerDtoToPayerEntity(body);
        mappedPayer.setContracts(contracts);
        PayerEntity payer = payerRepository.save(mappedPayer);

        if(body.note() != null) {
            PayerNoteEntity payerNotes = payerNotesMapper.toEntity(body.note());
            payerNotes.setPayer(payer);
            payer.setNote(payerNotes);
            payersNotesRepository.save(payerNotes);

        }

        return payerMapper.toModel(payer);
    }

    @Override
    public void deletePayerById(BigInteger payerId) {
        Optional<PayerEntity> foundPayer = payerRepository.findById(payerId);

        if(foundPayer.isPresent()) {
            payerRepository.deleteById(payerId);
        }
    }
}
