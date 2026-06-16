package com.woolie.CarehomeApi.mappers;

import com.woolie.CarehomeApi.domains.dtos.AdminDto;
import com.woolie.CarehomeApi.domains.entities.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdminMapper {
    AdminDto toDto(Admin admin);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Admin toEntity(AdminDto adminDto);
}
