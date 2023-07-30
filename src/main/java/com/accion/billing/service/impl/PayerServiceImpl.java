package com.accion.billing.service.impl;

import com.accion.billing.entities.PayerEntity;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.common.PageMetaDTO;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import com.accion.billing.models.mapper.PayerMapper;
import com.accion.billing.repository.PayerRepository;
import com.accion.billing.service.PayerService;
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
public class PayerServiceImpl implements PayerService {
    private final PayerRepository payerRepository;
    private final PayerMapper mapper;

    public PayerServiceImpl(PayerRepository payerRepository, PayerMapper mapper) {
        this.payerRepository = payerRepository;
        this.mapper = mapper;
    }

    @Override
    public PageDTO<List<PayerDTO>> getPayers(Pageable pageable) {
        Page<PayerEntity> foundPayers = payerRepository.findAll(pageable);
        return new PageDTO<>(
                foundPayers.stream().map(mapper::toModel).collect(Collectors.toList()),
                new PageMetaDTO<>(foundPayers)
        );
    }

    @Override
    public Optional<PayerDTO> getPayerById(BigInteger payerId) {
        Optional<PayerEntity> foundPayer = payerRepository.findById(payerId);
        return foundPayer.map(mapper::toModel);
    }

    @Override
    public PayerDTO createOrUpdatePayer(CreateOrUpdatePayerDTO body) {
        PayerEntity mappedPayer = mapper.createOrUpdatePayerDtoToPayerEntity(body);
        PayerEntity payer = payerRepository.save(mappedPayer);
        return mapper.toModel(payer);
    }

    @Override
    public void deletePayerById(BigInteger payerId) {
        Optional<PayerEntity> foundPayer = payerRepository.findById(payerId);

        if(foundPayer.isPresent()) {
            payerRepository.deleteById(payerId);
        }
    }
}
