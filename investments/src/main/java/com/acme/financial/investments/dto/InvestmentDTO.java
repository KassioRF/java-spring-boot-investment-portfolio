package com.acme.financial.investments.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentDTO {
    private UUID id;
    private EnumInvestmentType type;
    private String symbol;
    private Float quantity;
    private Float purchasePrice;
    private LocalDate purchaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
