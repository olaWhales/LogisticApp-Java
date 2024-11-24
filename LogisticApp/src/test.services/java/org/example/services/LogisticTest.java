package org.example.services;

import org.example.data.model.Package;

import org.example.data.model.Receiver;
import org.example.data.repository.PackageRepository;
import org.example.data.repository.ReceiverRepository;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.example.dto.respond.CreateReceiverRespond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@DataMongoTest
@SpringBootTest
public class LogisticTest {
    @Autowired
    PackageService packageService ;
    @Autowired
    PackageRepository packageRepository;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    ReceiverService receiverService ;
    @Autowired
    private ReceiverServiceImp receiverServiceImp;


    @BeforeEach
    void cleanUp() {
        packageRepository.deleteAll();
    }

    @Test
    public void testThatReceiverCanGetPackage() {
        CreatePackageRequest request = new CreatePackageRequest();
        Package Package = new Package();
        packageRepository.save(Package);
        CreatePackageRespond respond = packageService.createPackage(request);
        assertNotNull(respond);
        assertEquals(packageRepository.count(), 2);
    }
    @Test
    public void testThatReceiverCanRegister() {
        CreateReceiverRequest receiverRequest = new CreateReceiverRequest();
        CreateReceiverRespond respond = receiverService.respond(receiverRequest);
        Receiver receiver = new Receiver();
        receiver.setFullName(String.valueOf(receiverRequest.getReceiverName()));
        receiver.setAddress(receiverRequest.getReceiverAddress());
        receiver.setPhone(receiverRequest.getPhoneNumber());
        receiverRepository.save(receiver);
        respond.setMessage(respond.getMessage());
        assertEquals(respond.getMessage(), "Register successfully");
    }
}