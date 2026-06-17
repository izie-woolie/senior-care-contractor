package com.woolie.CarehomeApi.controllers;

import com.woolie.CarehomeApi.domains.dtos.ContractorDto;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.mappers.ContractorMapper;
import com.woolie.CarehomeApi.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contractors")
@RequiredArgsConstructor
public class ContractorController {
    private final ContractorService contractorService;
    private final ContractorMapper contractorMapper;

    @GetMapping
    public ResponseEntity<Page<ContractorDto>> getAllContractors(@PageableDefault(size = 20) Pageable pageable) {
        Page<Contractor> contractors = contractorService.getAllContractors(pageable);
        Page<ContractorDto> contractorDtos = contractors.map(contractorMapper::toDto);

        return ResponseEntity.ok(contractorDtos);
    }

    public void getContractor() {

    }

    public void updateContractor() {

    }
    public void deleteContractor() {

    }
}
