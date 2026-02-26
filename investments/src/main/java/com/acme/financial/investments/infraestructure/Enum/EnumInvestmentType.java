package com.acme.financial.investments.infraestructure.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumInvestmentType {

    ACAO(1, "ACAO", " Ações da bolsa"),

    CRIPTO(2, "CRIPTO", "Criptomoedas"),

    FUNDO(3, "FUNDO", "Fundo de Investimento"),

    RENDA_FIXA(4, "RENDA_FIXA", "Títulos de renda fixa"),

    OUTRO(5, "OUTRO", "Qualquer outro tipo");

    private Integer id;
    private String name;
    private String description;

}
