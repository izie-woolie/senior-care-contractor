package com.woolie.CarehomeApi.controllers;

import com.woolie.CarehomeApi.domains.dtos.AdminDto;
import com.woolie.CarehomeApi.domains.dtos.ContractorDto;
import com.woolie.CarehomeApi.domains.dtos.RegisterAdminRequestDto;
import com.woolie.CarehomeApi.domains.dtos.RegisterContractorRequestDto;
import com.woolie.CarehomeApi.domains.entities.Admin;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import com.woolie.CarehomeApi.mappers.AdminMapper;
import com.woolie.CarehomeApi.mappers.AuthMapper;
import com.woolie.CarehomeApi.mappers.ContractorMapper;
import com.woolie.CarehomeApi.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthMapper authMapper;
    private final AdminMapper adminMapper;
    private final ContractorMapper contractorMapper;
    private final AuthService authService;

   @PostMapping("login")
   public void login() {

   }

   @PostMapping("register/contractor")
   public ResponseEntity<ContractorDto> registerContractor(@Valid @RequestBody RegisterContractorRequestDto registerContractorRequestDto) {
       Contractor contractorToRegister = authMapper.toContractor(registerContractorRequestDto);
       Contractor savedContractor = authService.createContractor(contractorToRegister);
       return new ResponseEntity<>(contractorMapper.toDto(savedContractor), HttpStatus.CREATED);
   }

   @PostMapping("register/admin")
   public ResponseEntity<AdminDto> registerAdmin(@Valid @RequestBody RegisterAdminRequestDto registerAdminRequestDto) {
       Admin adminToRegister = authMapper.toAdmin(registerAdminRequestDto);
       Admin savedAdmin = authService.createAdmin(adminToRegister);
       return new ResponseEntity<>(adminMapper.toDto(savedAdmin), HttpStatus.CREATED);
   }
}
