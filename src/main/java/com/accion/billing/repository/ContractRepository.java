package com.accion.billing.repository;

import com.accion.billing.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, BigInteger> {
    @Query(value = "SELECT * FROM contracts WHERE id IN ?1", nativeQuery = true)
    List<ContractEntity> getContracts(List<BigInteger> ids);
}
