package com.acme.financial.investments.usecase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.acme.financial.investments.dto.InvestmentSummaryDTO;
import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InvestmentSummaryUseCase {
    private final IInvestmentRepository repository;

    // tem que tipar o sumário
    public InvestmentSummaryDTO execute() {
        List<InvestmentEntity> items = repository.findAll();

        float totalInvested = 0f;
        Map<EnumInvestmentType, Float> totalByType = new HashMap<>();

        for (InvestmentEntity inv : items) {
            float value = inv.getPurchasePrice() * inv.getQuantity();
            value = round2(value);
            totalInvested += value;

            totalByType.put(inv.getType(),
                    round2(totalByType.getOrDefault(inv.getType(), 0f) + value));
        }

        return InvestmentSummaryDTO.builder()
                .totalInvested(round2(totalInvested))
                .totalByType(totalByType)
                .assetCount(items.size())
                .build();

    }

    private float round2(float value) {
        return (float) (Math.floor(value * 100) / 100);
    }
}
