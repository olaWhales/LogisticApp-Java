package org.example.services;

import org.example.dto.request.CreatePackageRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.springframework.stereotype.Service;
@Service
public interface PackageService {

    CreatePackageRespond createPackageRespond(CreatePackageRequest request);
}
