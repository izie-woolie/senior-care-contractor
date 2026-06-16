package com.woolie.CarehomeApi.mappers;

import com.woolie.CarehomeApi.domains.dtos.ContractorDto;
import com.woolie.CarehomeApi.domains.entities.Contractor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContractorMapper {
    ContractorDto toDto(Contractor contractor);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Contractor toEntity(ContractorDto contractorDto);
}
