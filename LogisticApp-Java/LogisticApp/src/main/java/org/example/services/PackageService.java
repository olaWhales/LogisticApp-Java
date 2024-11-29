package org.example.services;

import org.example.data.model.Package;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.respond.CreatePackageRespond;


public interface PackageService {

//    void createPackage(CreatePackageRequest request , Package newPackage);
    CreatePackageRespond CreatePackageRespond (CreatePackageRequest request);

//    CreatePackageRespond createPackageRespond(CreatePackageRequest request , Package newPackage);
//    CreatePackageRespond getPackage (CreatePackageRespond createPackageRespond);
}
