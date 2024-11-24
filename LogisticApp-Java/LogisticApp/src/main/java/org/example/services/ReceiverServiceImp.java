package org.example.services;

import org.example.data.model.Receiver;
import org.example.data.repository.ReceiverRepository;
import org.example.dto.request.CreateReceiverRequest;
import org.example.dto.respond.CreateReceiverRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImp implements ReceiverService {
    @Autowired
    ReceiverRepository receiverRepository;

    @Override
    public CreateReceiverRespond respond(CreateReceiverRequest request) {
        CreateReceiverRespond receiverRespond = new CreateReceiverRespond();
        Receiver receiver = new Receiver();
        receiver.setPhone(request.getPhoneNumber());
        receiver.setFullName(String.valueOf(request.getReceiverName()));
        receiver.setAddress(request.getReceiverAddress());
        receiverRepository.save(receiver);
        receiverRespond.setMessage("Receiver register successfully");
        return receiverRespond;
    }

}
