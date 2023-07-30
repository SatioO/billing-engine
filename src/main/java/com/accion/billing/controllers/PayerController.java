package com.accion.billing.controllers;

import com.accion.billing.exceptions.PayerNotFoundException;
import com.accion.billing.models.dto.common.PageDTO;
import com.accion.billing.models.dto.payer.CreateOrUpdatePayerDTO;
import com.accion.billing.models.dto.payer.PayerDTO;
import com.accion.billing.service.PayerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/payers")
public class PayerController {
    private final PayerService payerService;

    public PayerController(PayerService payerService) {
        this.payerService = payerService;
    }

    @GetMapping
    public ResponseEntity<PageDTO<List<PayerDTO>>> getPayers(Pageable pageable) {
        PageDTO<List<PayerDTO>> payers = payerService.getPayers(pageable);
        return ResponseEntity.ok().body(payers);
    }

    @GetMapping("/{payerId}")
    public ResponseEntity<PayerDTO> getPayerById(@PathVariable BigInteger payerId) {
        Optional<PayerDTO> foundPayer = payerService.getPayerById(payerId);
        return foundPayer
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PayerNotFoundException(payerId));
    }

    @PutMapping
    public ResponseEntity<PayerDTO> createOrUpdatePayer(@Valid @RequestBody CreateOrUpdatePayerDTO body) {
        PayerDTO payer = payerService.createOrUpdatePayer(body);
        return ResponseEntity.ok().body(payer);
    }

    @DeleteMapping("/{payerId}")
    public ResponseEntity<Void> deletePayerById(@PathVariable BigInteger payerId) {
        payerService.deletePayerById(payerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
