package com.woolie.CarehomeApi.controllers;

import com.woolie.CarehomeApi.domains.dtos.ContractorDto;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.mappers.ContractorMapper;
import com.woolie.CarehomeApi.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contractors")
@RequiredArgsConstructor
public class ContractorController {
    private final ContractorService contractorService;
    private final ContractorMapper contractorMapper;

    @GetMapping
    public ResponseEntity<List<ContractorDto>> getAllContractors() {
        List<Contractor> contractors = contractorService.getAllContractors();
        List<ContractorDto> contractorDtos = contractors.stream().map(contractorMapper::toDto).toList();

        return ResponseEntity.ok(contractorDtos);
    }

    public void getContractor() {

    }

    public void updateContractor() {

    }
    public void deleteContractor() {

    }
}
