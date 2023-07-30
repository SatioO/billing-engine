package com.accion.billing.repository;

import com.accion.billing.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, BigInteger> {
}
