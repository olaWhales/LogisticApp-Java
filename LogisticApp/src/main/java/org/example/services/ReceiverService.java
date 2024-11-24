package org.example.services;

import org.example.data.model.Receiver;
import org.example.dto.request.CreatePackageRequest;
import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.respond.CreatePackageRespond;
import org.example.dto.respond.CreateReceiverRespond;


public interface ReceiverService {
    CreateReceiverRespond respond (CreateReceiverRequest request);
}
