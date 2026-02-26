package com.acme.financial.investments.usecase;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.acme.financial.investments.exception.UseCaseException;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteInvestmentUseCase {
    private final IInvestmentRepository repository;

    public void execute(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new UseCaseException("Investment not found"));
        repository.deleteById(id);

    }
}
