package com.woolie.CarehomeApi.services;

import com.woolie.CarehomeApi.domains.entities.Contractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractorService {
    Page<Contractor> getAllContractors(Pageable pageable);
}
