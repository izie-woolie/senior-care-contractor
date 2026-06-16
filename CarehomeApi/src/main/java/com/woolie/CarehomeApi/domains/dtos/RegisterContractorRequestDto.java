package com.woolie.CarehomeApi.domains.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterContractorRequestDto {

    @NotBlank(message = "Email  is required")
    @Email(message = "Must be valid email address")
    private String email;

    @NotBlank(message = "Phone Number is required")
    private String phoneNo;

    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Description must be more than 10 words")
    private String description;


    @NotBlank(message = "Company name is required")
    private String companyName;

    @Size(min = 2, max = 6, message = "Please put between {min} and {max} skills")
    private List<@Valid @NotBlank(message = "Skill cannot be empty") String> skills;
}
