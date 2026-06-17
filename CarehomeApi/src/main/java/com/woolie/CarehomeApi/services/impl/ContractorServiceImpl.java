package com.woolie.CarehomeApi.services.impl;

import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.repositories.ContractorRepository;
import com.woolie.CarehomeApi.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;

    @Override
    public Page<Contractor> getAllContractors(Pageable pageable) {
        return contractorRepository.findAll(pageable);
    }
}
