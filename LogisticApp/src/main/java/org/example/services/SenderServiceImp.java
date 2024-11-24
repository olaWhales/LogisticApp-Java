package org.example.services;

import org.example.data.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImp implements SenderService {
    @Autowired
    SenderRepository senderRepository;
}
