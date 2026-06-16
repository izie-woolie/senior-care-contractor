package com.woolie.CarehomeApi.mappers;

import com.woolie.CarehomeApi.domains.dtos.RegisterAdminRequestDto;
import com.woolie.CarehomeApi.domains.dtos.RegisterContractorRequestDto;
import com.woolie.CarehomeApi.domains.entities.Admin;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target ="createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "applications", ignore = true)
    Contractor toContractor(RegisterContractorRequestDto registerContractorRequestDto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target ="createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Admin toAdmin(RegisterAdminRequestDto registerAdminRequestDto);
}
