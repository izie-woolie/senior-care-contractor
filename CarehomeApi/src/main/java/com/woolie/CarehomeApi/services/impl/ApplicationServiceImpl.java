package com.woolie.CarehomeApi.services.impl;

import com.woolie.CarehomeApi.domains.entities.Application;
import com.woolie.CarehomeApi.repositories.ApplicationRepository;
import com.woolie.CarehomeApi.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

   private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return List.of();
    }
}
