package com.acme.financial.investments.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.acme.financial.investments.converter.InvestmentConverter;
import com.acme.financial.investments.dto.InvestmentDTO;
import com.acme.financial.investments.dto.UpdateInvestmentDTO;
import com.acme.financial.investments.exception.UseCaseException;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateInvestmentUseCase {
    private final IInvestmentRepository repository;

    public InvestmentDTO execute(UUID id, UpdateInvestmentDTO payload) {
        InvestmentEntity investment = repository.findById(id)
                .orElseThrow(() -> new UseCaseException("Investment not found"));

        if (payload.getType() != null)
            investment.setType(payload.getType());
        if (payload.getSymbol() != null)
            investment.setSymbol(payload.getSymbol());
        if (payload.getQuantity() != null)
            investment.setQuantity(payload.getQuantity());
        if (payload.getPurchasePrice() != null)
            investment.setPurchasePrice(payload.getPurchasePrice());
        if (payload.getPurchaseDate() != null)
            investment.setPurchaseDate(payload.getPurchaseDate());

        InvestmentEntity updated = repository.save(investment);
        return InvestmentConverter.toDTO(updated);
    }
}
