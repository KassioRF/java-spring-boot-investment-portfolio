package com.acme.financial.investments.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.acme.financial.investments.converter.InvestmentConverter;
import com.acme.financial.investments.dto.InvestmentDTO;
import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindInvestmentUseCase {
    private final IInvestmentRepository repository;

    public List<InvestmentDTO> findAll() {
        List<InvestmentEntity> items = this.repository.findAll();
        return items.stream()
                .map(InvestmentConverter::toDTO)
                .toList();
    }

    public List<InvestmentDTO> findByType(EnumInvestmentType type) {
        List<InvestmentEntity> items = this.repository.findByType(type);
        return items.stream()
                .map(InvestmentConverter::toDTO)
                .toList();
    }
}
