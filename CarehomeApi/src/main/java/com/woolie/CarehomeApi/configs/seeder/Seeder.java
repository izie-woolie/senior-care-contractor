package com.woolie.CarehomeApi.configs.seeder;

import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.repositories.ContractorRepository;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final ContractorRepository contractorRepository;

    @Override
    public void run(String... args) throws Exception {
        if (contractorRepository.count() > 0) {
            return;
        }

        Faker faker = new Faker();
        List<Contractor> contractors = IntStream.range(0, 15)
                .mapToObj(i -> Contractor.builder()
                        .email(faker.internet().emailAddress())
                        .phoneNo(faker.phoneNumber().phoneNumber())
                        .description(faker.lorem().sentence(12))
                        .companyName(faker.company().name())
                        .skills(randomSkills(faker))
                        .applications(new ArrayList<>())
                        .build())
                .collect(Collectors.toList());

        contractorRepository.saveAll(contractors);
        System.out.println("Seeded " + contractors.size() + " contractors.");
    }

    private static final List<String> SKILL_POOL = List.of(
            "Electrical", "Plumbing", "Cleaning", "Landscaping", "General");

    private List<String> randomSkills(Faker faker) {
        List<String> shuffled = new ArrayList<>(SKILL_POOL);
        Collections.shuffle(shuffled);
        int count = faker.number().numberBetween(2, 5);
        return shuffled.subList(0, count);
    }
}
