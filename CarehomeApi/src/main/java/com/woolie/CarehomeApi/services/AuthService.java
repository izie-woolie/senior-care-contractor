package com.woolie.CarehomeApi.services;

import com.woolie.CarehomeApi.domains.entities.Admin;
import com.woolie.CarehomeApi.domains.entities.Contractor;

public interface AuthService {
    Contractor createContractor(Contractor contractor);
    Admin createAdmin(Admin admin);
}
