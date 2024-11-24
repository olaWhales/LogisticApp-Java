package org.example.services;

import org.example.data.model.TrackingLog;
import org.example.data.model.Receiver;
import org.example.data.model.Sender;
import org.example.data.model.Package;
import org.example.data.repository.TrackingLogRepository;
import org.example.data.repository.PackageRepository;
import org.example.data.repository.ReceiverRepository;
import org.example.data.repository.SenderRepository;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImp implements PackageService {
    @Autowired
    TrackingLogRepository trackingLogRepository;
    @Autowired
    ReceiverRepository receiverRepository;
    @Autowired
    SenderRepository senderRepository;
    @Autowired
    PackageRepository packageRepository;
    @Autowired
    private ReceiverServiceImp receiverServiceImp;

    @Override
    public CreatePackageRespond createPackage(CreatePackageRequest request) {
        TrackingLog trackingLog = new TrackingLog();
        trackingLog.setDescription(request.getDescription());
        trackingLogRepository.save(trackingLog);
        Receiver receiver = new Receiver();
        request.setQuantity(request.getQuantity());
        request.setReceiverFullName(request.getReceiverFullName());
        receiverRepository.save(receiver);
        Sender sender = new Sender();
        sender.setName(String.valueOf(request.getSenderFullName()));
        sender.setPhoneNumber(request.getSenderPhoneNumber());
        senderRepository.save(sender);
       Package package1 = new Package();
       package1.setSender(request.getSenderFullName());
       package1.setQuantity(request.getQuantity());
       package1.setReceiver(request.getReceiverFullName());
       package1.setDescription(request.getDescription());
       packageRepository.save(package1);
        CreatePackageRespond respond = new CreatePackageRespond();
        respond.getStuff();
        respond.getCreateDate();
        respond.getSender();
        respond.getTrackingNumber();
        respond.getCreateDate();
        return packageRepository.count() > 0 ? new CreatePackageRespond() : null;

    }

}
