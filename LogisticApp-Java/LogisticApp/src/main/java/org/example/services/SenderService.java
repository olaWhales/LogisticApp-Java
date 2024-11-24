package org.example.services;

import org.example.dto.request.CreateSenderRequest;
import org.example.dto.respond.CreateSenderRespond;
import org.springframework.stereotype.Service;


public interface SenderService {
    CreateSenderRespond respond (CreateSenderRequest request);
}
