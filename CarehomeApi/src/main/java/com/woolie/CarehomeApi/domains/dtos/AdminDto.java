package com.woolie.CarehomeApi.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private UUID id;
    private String email;
    private String phoneNo;
}
