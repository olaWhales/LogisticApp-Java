package org.example.services;

import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.respond.CreateReceiverRespond;


public interface ReceiverService {
    CreateReceiverRespond createReceiver(CreateReceiverRequest request);
}
