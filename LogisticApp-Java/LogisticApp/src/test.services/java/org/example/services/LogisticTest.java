package org.example.services;

import org.example.data.model.Package;

import org.example.data.model.Receiver;
import org.example.data.model.Sender;
import org.example.data.model.TrackingLog;
import org.example.data.repository.PackageRepository;
import org.example.data.repository.ReceiverRepository;
import org.example.data.repository.SenderRepository;
import org.example.data.repository.TrackingLogRepository;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.request.CreateSenderRequest;
import org.example.dto.request.CreateTrackingLogRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.example.dto.respond.CreateReceiverRespond;
import org.example.dto.respond.CreateSenderRespond;
import org.example.dto.respond.CreateTrackingLogRespond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
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
    ReceiverRepository receiverRepository;
    @Autowired
    ReceiverService receiverService ;
    @Autowired
    private SenderServiceImp senderServiceImp;
    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private TrackingLogServiceImp trackingLogServiceImp;
    @Autowired
    private TrackingLogRepository trackingLogRepository;


    @BeforeEach
    void cleanUp() {
        packageRepository.deleteAll();
        receiverRepository.deleteAll();
        senderRepository.deleteAll();
        trackingLogRepository.deleteAll();
    }

    @Test
    public void testThatReceiverCanGetPackage() {
        CreatePackageRequest request = new CreatePackageRequest();
        Package Package = new Package();
        packageRepository.save(Package);
        CreatePackageRespond respond = packageService.createPackageRespond(request);
        assertNotNull(respond);
        assertEquals(packageRepository.count(), 1);
        System.out.println(respond);
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
        assertEquals(respond.getMessage(), "Receiver register successfully");
    }
    @Test
    public void testThatSenderCanRegister() {
        CreateSenderRespond respond = senderServiceImp.respond(new CreateSenderRequest());
        CreateSenderRequest request = new CreateSenderRequest();
        Sender sender = new Sender();
        sender.setPhoneNumber(request.getPhoneNumber());
        sender.setName(request.getSenderName());
        senderRepository.save(sender);
        respond.setMesssage(respond.getMesssage());
        assertEquals(respond.getMesssage(), "Sender register successfully");
    }
    @Test
    public void testToCheckTrackingDetailLog(){
        CreateTrackingLogRequest request = new CreateTrackingLogRequest();
        CreateTrackingLogRespond respond = trackingLogServiceImp.respond(new CreateTrackingLogRequest());
        TrackingLog trackingLog = new TrackingLog();
        trackingLog.setTrackingDate(request.getTrackingDateTime());
        trackingLog.setDescription(request.getDescription());
        trackingLog.setTrackingNumber(request.getTrackingNumber());
        trackingLogRepository.save(trackingLog);
        respond.setMessage(respond.getMessage());
        assertEquals(respond.getMessage() , "Details is intact");
    }

}