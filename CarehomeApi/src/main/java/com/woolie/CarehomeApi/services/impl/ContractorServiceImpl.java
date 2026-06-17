package com.woolie.CarehomeApi.services.impl;

import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.repositories.ContractorRepository;
import com.woolie.CarehomeApi.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;

    @Override
    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }
}
