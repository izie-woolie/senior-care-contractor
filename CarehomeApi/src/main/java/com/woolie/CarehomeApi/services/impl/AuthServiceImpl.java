package com.woolie.CarehomeApi.services.impl;

import com.woolie.CarehomeApi.domains.entities.Admin;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.repositories.AdminRepository;
import com.woolie.CarehomeApi.repositories.ContractorRepository;
import com.woolie.CarehomeApi.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ContractorRepository contractorRepository;
    private final AdminRepository adminRepository;

    @Override
    public Contractor createContractor(Contractor contractor) {
        return contractorRepository.save(contractor);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
