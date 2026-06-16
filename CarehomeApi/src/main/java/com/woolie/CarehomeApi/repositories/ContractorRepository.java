package com.woolie.CarehomeApi.repositories;

import com.woolie.CarehomeApi.domains.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, UUID> {
}
