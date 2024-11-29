package org.example.services;

import org.example.Util.Mapper;
import org.example.data.model.Receiver;
import org.example.data.model.Sender;
import org.example.data.model.TrackingLog;
import org.example.data.repository.TrackingLogRepository;
import org.example.data.repository.PackageRepository;
import org.example.data.repository.ReceiverRepository;
import org.example.data.repository.SenderRepository;
import org.example.dto.request.CreatePackageRequest;
import org.example.data.model.Package;

import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.request.CreateSenderRequest;
import org.example.dto.request.CreateTrackingLogRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.example.dto.respond.CreateTrackingLogRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.example.Util.Mapper.map;

//import static org.example.Util.Mapper.map;

@Service
public class PackageServiceImp implements PackageService {
    @Autowired
    private TrackingLogRepository trackingLogRepository;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private ReceiverServiceImp receiverServiceImp;
    @Autowired
    private SenderService senderService;
    @Autowired
    private SenderServiceImp senderServiceImp;
    @Autowired
    private TrackingLogService trackingLogService;

    @Override
    public CreatePackageRespond CreatePackageRespond(CreatePackageRequest createPackageRequest) {

        List<TrackingLog> trackingLogs = trackingLogRepository.findAll();

        //      Map the request to a Sender object and save it
        Sender sender = new Sender();
        sender.setFullName(String.valueOf(createPackageRequest.getSenderFullName()));
        sender.setPhoneNumber(String.valueOf(createPackageRequest.getSenderPhoneNumber()));
//             senderRepository.save(sender);

//              Map the request to a Receiver object and save it
        Receiver receiver = new Receiver();
        receiver.setFullName(String.valueOf(createPackageRequest.getReceiverFullName()));
        receiver.setAddress(String.valueOf(createPackageRequest.getReceiverAddress()));
//             receiverRepository.save(receiver);

//              Map the request to a Package object and save it
        Package aPackage = new Package();
        aPackage.setDescription(createPackageRequest.getDescription());
        aPackage.setQuantity(createPackageRequest.getQuantity());
//             packageRepository.save(aPackage);

//        TrackingLog trackingLog = map(trackingLogService.createTrackingLogRespond(CreateTrackingLogRequest));
//        CreateTrackingLogRequest createTrackingLogRequest = map(trackingLog);
//        TrackingLog tracking= map(trackingLogService.createTrackingLogRespond(createTrackingLogRequest))
//        trackingLog.setTrackingNumber(trackingLog.getTrackingNumber());
//        trackingLog.setTrackingDate(trackingLog.getTrackingDate());


//              Create and return the response
        CreatePackageRespond response = new CreatePackageRespond();
        response.setSender(sender.getId());
        response.setReceiver(receiver.getId());
        response.setStuff(aPackage.getId());
//        response.setTrackingLog(response.getTrackingLog());
        response.setCreateDate(LocalDateTime.now());
        response.setDelivery(aPackage.getDeliveryFee());
        return response;
    }
}

//    private TrackingLog map(CreateTrackingLogRespond trackingLogRespond) {
//    }
//}