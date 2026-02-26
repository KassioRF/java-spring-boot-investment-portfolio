package com.acme.financial.investments.dto;

import java.util.Map;

import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentSummaryDTO {
    private Float totalInvested;
    private Map<EnumInvestmentType, Float> totalByType;
    private Integer assetCount;
}
