package com.acme.financial.investments.seed;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acme.financial.investments.infraestructure.Enum.EnumInvestmentType;
import com.acme.financial.investments.infraestructure.entity.InvestmentEntity;
import com.acme.financial.investments.infraestructure.repository.IInvestmentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SeedDatabase implements CommandLineRunner {

    private final IInvestmentRepository repository;
    private final Random random = new Random();

    @Override
    public void run(String... args) {
        repository.deleteAll(); // limpa a tabela

        for (int i = 1; i <= 20; i++) {
            InvestmentEntity inv = InvestmentEntity.builder()
                    .type(EnumInvestmentType.values()[random.nextInt(EnumInvestmentType.values().length)])
                    .symbol("SYM" + i)
                    .quantity(random.nextFloat() * 100)
                    .purchasePrice(random.nextFloat() * 1000)
                    .purchaseDate(LocalDate.now().minusDays(random.nextInt(365)))
                    .build();
            repository.save(inv);
        }

        System.out.println("Seed de investimentos concluído!");
    }

}
