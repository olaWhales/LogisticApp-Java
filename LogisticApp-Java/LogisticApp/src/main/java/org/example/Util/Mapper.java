package org.example.Util;

import org.example.data.model.Receiver;
import org.example.data.model.Sender;
import org.example.data.model.TrackingLog;
import org.example.data.model.Package;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.request.CreateSenderRequest;
import org.example.dto.request.CreateTrackingLogRequest;

public class Mapper {

    public static CreateSenderRequest map(Sender sender) {
        CreateSenderRequest createSenderRequest = new CreateSenderRequest();
        createSenderRequest.setSenderName(sender.getFullName());
        createSenderRequest.setPhoneNumber(sender.getPhoneNumber());
        return createSenderRequest;
    }
    public static CreateReceiverRequest map(Receiver receiver) {
        CreateReceiverRequest createReceiverRequest = new CreateReceiverRequest();
        receiver.setFullName(createReceiverRequest.getReceiverName());
        receiver.setAddress(createReceiverRequest.getReceiverAddress());
        receiver.setPhone(createReceiverRequest.getPhoneNumber());
        return createReceiverRequest;
    }
    public static CreateTrackingLogRequest map(TrackingLog trackingLog) {
        CreateTrackingLogRequest createTrackingLogRequest = new CreateTrackingLogRequest();
        createTrackingLogRequest.setTrackingNumber(trackingLog.getTrackingNumber());
        createTrackingLogRequest.setTrackingDateTime(trackingLog.getTrackingDate());
        return createTrackingLogRequest;
    }
    public static CreatePackageRequest map(Package aPackage) {
        CreatePackageRequest createPackageRequest = new CreatePackageRequest();
        createPackageRequest.setDescription(aPackage.getDescription());
        createPackageRequest.setQuantity(aPackage.getQuantity());
        return createPackageRequest;
    }

}
