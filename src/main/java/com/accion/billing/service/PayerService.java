package com.accion.billing.service;

import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PayerService {
    PageDTO<List<PayerDTO>> getPayers(Pageable pageable);
    Optional<PayerDTO> getPayerById(BigInteger payerId);
    PayerDTO createOrUpdatePayer(CreateOrUpdatePayerDTO payer);
    void deletePayerById(BigInteger payerId);
}
