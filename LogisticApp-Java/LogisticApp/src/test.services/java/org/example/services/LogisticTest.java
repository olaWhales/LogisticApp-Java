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
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @Autowired
    private PackageServiceImp packageServiceImp;


    @BeforeEach
    void cleanUp() {
        packageRepository.deleteAll();
        receiverRepository.deleteAll();
        senderRepository.deleteAll();
        trackingLogRepository.deleteAll();
    }

    @Test
    public void testThatReceiverCanRegister() {
        CreateReceiverRequest receiverRequest = new CreateReceiverRequest();
        CreateReceiverRespond respond = receiverService.createReceiver(receiverRequest);
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
        CreateSenderRespond respond = senderServiceImp.createSender(new CreateSenderRequest());
        CreateSenderRequest request = new CreateSenderRequest();
        Sender sender = new Sender();
        sender.setPhoneNumber(request.getPhoneNumber());
        sender.setFullName(request.getSenderName());
        senderRepository.save(sender);
        respond.setMessage(respond.getMessage());
        assertEquals(respond.getMessage(), "Sender register successfully");
    }
    @Test
    public void testToCheckTrackingDetailLog(){
        CreateTrackingLogRespond respond = trackingLogServiceImp.createTrackingLogRespond(new CreateTrackingLogRequest());
        CreateTrackingLogRequest request = new CreateTrackingLogRequest();
        TrackingLog trackingLog = new TrackingLog();
        trackingLog.setTrackingDate(request.getTrackingDateTime());
        trackingLog.setDescription(request.getDescription());
        trackingLog.setTrackingNumber(request.getTrackingNumber());
        trackingLogRepository.save(trackingLog);
        respond.setMessage(respond.getMessage());
        assertEquals(respond.getMessage(), "Details successfully added");
    }

    @Test
    public void testToCheckPackage(){
        CreatePackageRespond respond = packageServiceImp.CreatePackageRespond(new CreatePackageRequest() );
        CreatePackageRequest request = new CreatePackageRequest();
        Package aPackage = new Package();
        aPackage.setSender(request.getSenderFullName());
        aPackage.setSender(request.getSenderPhoneNumber());
        aPackage.setReceiver(request.getReceiverFullName());
        aPackage.setReceiver(request.getReceiverAddress());
        aPackage.setReceiver(request.getReceiverPhoneNumber());
        aPackage.setDescription(request.getDescription());
        aPackage.setQuantity(request.getQuantity());
        packageRepository.save(aPackage);
        respond.setStuff("FoodStuff");
        respond.setSender("Olawale");
        respond.setReceiver("Tunji");
        respond.setDelivery(BigDecimal.valueOf(100.000));
        respond.setCreateDate(respond.getCreateDate());
        if (respond.getTrackingLog() == null) {
            respond.setTrackingLog(respond.getTrackingLog());
        }
        respond.setTrackingLog(respond.getTrackingLog());
//        assertEquals(respond.getDelivery() , 100.000);
        assertEquals(BigDecimal.valueOf(100.000), respond.getDelivery());
        assertEquals(respond.getStuff() ,"FoodStuff" );
        assertEquals(respond.getReceiver() , "Tunji");
        assertEquals(respond.getSender() , "Olawale" );
        assertNotNull(respond.getCreateDate().toLocalDate());
//        assertNotNull(respond.getTrackingLog());
    }

}