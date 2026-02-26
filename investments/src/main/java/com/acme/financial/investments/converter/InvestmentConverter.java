package com.acme.financial.investments.converter;

import com.acme.financial.investments.dto.CreateInvestmentDTO;
import com.acme.financial.investments.dto.InvestmentDTO;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;

public class InvestmentConverter {

    // DTO -> Entity
    public static InvestmentDTO toDTO(InvestmentEntity entity) {
        return InvestmentDTO.builder()
                .id(entity.getId())
                .type(entity.getType())
                .symbol(entity.getSymbol())
                .quantity(entity.getQuantity())
                .purchasePrice(entity.getPurchasePrice())
                .purchaseDate(entity.getPurchaseDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())

                .build();
    }

    // Entity -> DTO
    public static InvestmentEntity toEntity(InvestmentDTO dto) {
        return InvestmentEntity.builder()
                .id(dto.getId())
                .type(dto.getType())
                .symbol(dto.getSymbol())
                .quantity(dto.getQuantity())
                .purchasePrice(dto.getPurchasePrice())
                .purchaseDate(dto.getPurchaseDate())
                .build();
    }

    // Overload Entity -> CreateDTO
    public static InvestmentEntity toEntity(CreateInvestmentDTO dto) {
        return InvestmentEntity.builder()
                .type(dto.getType())
                .symbol(dto.getSymbol())
                .quantity(dto.getQuantity())
                .purchasePrice(dto.getPurchasePrice())
                .purchaseDate(dto.getPurchaseDate())
                .build();
    }

}
