package com.acme.financial.investments.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acme.financial.investments.dto.CreateInvestmentDTO;
import com.acme.financial.investments.dto.InvestmentDTO;
import com.acme.financial.investments.dto.InvestmentSummaryDTO;
import com.acme.financial.investments.dto.UpdateInvestmentDTO;
import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;
import com.acme.financial.investments.usecase.CreateInvestmentUseCase;
import com.acme.financial.investments.usecase.DeleteInvestmentUseCase;
import com.acme.financial.investments.usecase.FindInvestmentUseCase;
import com.acme.financial.investments.usecase.InvestmentSummaryUseCase;
import com.acme.financial.investments.usecase.UpdateInvestmentUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("investments")
@RequiredArgsConstructor
public class InvestmentController {

    private final CreateInvestmentUseCase createUseCase;
    private final FindInvestmentUseCase findInvestmentUseCase;
    private final UpdateInvestmentUseCase updateInvestmentUseCase;
    private final DeleteInvestmentUseCase deleteInvestmentUseCase;
    private final InvestmentSummaryUseCase investmentSummaryUseCase;

    @PostMapping
    public ResponseEntity<InvestmentDTO> create(@RequestBody CreateInvestmentDTO payload) {
        return ResponseEntity.ok(createUseCase.execute(payload));
    }

    @GetMapping
    public ResponseEntity<List<InvestmentDTO>> findAll(
            @RequestParam(required = false) EnumInvestmentType type) {
        if (type != null) {
            return ResponseEntity.ok(findInvestmentUseCase.findByType(type));
        }
        return ResponseEntity.ok(findInvestmentUseCase.findAll());
    }

    @PutMapping("id/{id}")
    public ResponseEntity<InvestmentDTO> update(
            @PathVariable UUID id, @RequestBody UpdateInvestmentDTO payload) {
        return ResponseEntity.ok(updateInvestmentUseCase.execute(id, payload));
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteInvestmentUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("summary")
    public ResponseEntity<InvestmentSummaryDTO> summary() {
        return ResponseEntity.ok(investmentSummaryUseCase.execute());
    }

}
