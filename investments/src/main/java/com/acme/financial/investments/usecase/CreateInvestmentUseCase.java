package com.acme.financial.investments.usecase;

import org.springframework.stereotype.Component;

import com.acme.financial.investments.converter.InvestmentConverter;
import com.acme.financial.investments.dto.CreateInvestmentDTO;
import com.acme.financial.investments.dto.InvestmentDTO;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateInvestmentUseCase {

    private final IInvestmentRepository repository;

    public InvestmentDTO execute(CreateInvestmentDTO payload) {
        InvestmentEntity entity = InvestmentConverter.toEntity(payload);
        return InvestmentConverter.toDTO(repository.save(entity));
    }

}
