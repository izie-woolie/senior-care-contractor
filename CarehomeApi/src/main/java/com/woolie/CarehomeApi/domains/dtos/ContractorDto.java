package com.woolie.CarehomeApi.domains.dtos;

import com.woolie.CarehomeApi.domains.entities.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractorDto {
    private UUID id;
    private String email;
    private String phoneNo;
    private String description;
    private String companyName;
    private List<String> skills;
    private List<Application> applications;
}
