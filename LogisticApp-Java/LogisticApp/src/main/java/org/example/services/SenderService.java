package org.example.services;

import org.example.dto.request.CreateSenderRequest;
import org.example.dto.respond.CreateSenderRespond;


public interface SenderService {
    CreateSenderRespond createSender(CreateSenderRequest request);

}
