package com.woolie.CarehomeApi.domains.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("admin")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Admin extends User{
}
