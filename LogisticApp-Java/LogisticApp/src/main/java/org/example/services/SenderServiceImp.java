package org.example.services;

import org.example.data.model.Sender;
import org.example.data.repository.SenderRepository;
import org.example.dto.request.CreateSenderRequest;
import org.example.dto.respond.CreateSenderRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImp implements SenderService {
    @Autowired
    SenderRepository senderRepository;

    @Override
    public CreateSenderRespond respond(CreateSenderRequest request) {
        CreateSenderRespond createSenderRespond = new CreateSenderRespond();
        Sender sender = new Sender();
        sender.setName(request.getSenderName());
        sender.setPhoneNumber(request.getPhoneNumber());
        senderRepository.save(sender);
        createSenderRespond.setMesssage("Sender register successfully");
        return createSenderRespond;
    }
}
