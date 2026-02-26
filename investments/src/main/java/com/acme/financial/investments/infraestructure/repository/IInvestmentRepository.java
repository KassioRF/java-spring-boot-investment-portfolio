package com.acme.financial.investments.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;

public interface IInvestmentRepository extends JpaRepository<InvestmentEntity, UUID> {

    Optional<InvestmentEntity> findById(UUID id);

    List<InvestmentEntity> findByType(EnumInvestmentType type);
}
