package com.woolie.CarehomeApi.domains.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdminRequestDto {

    @NotBlank(message = "Email  is required")
    @Email(message = "Must be valid email address")
    private String email;

    @NotBlank(message = "Phone Number is required")
    private String phoneNo;
}
