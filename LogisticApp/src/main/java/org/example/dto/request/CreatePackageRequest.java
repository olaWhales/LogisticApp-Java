package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Receiver;
import org.example.data.model.Sender;

@Data
public class CreatePackageRequest {
    private Sender senderFullName ;
    private Receiver receiverFullName ;
    private String senderPhoneNumber ;
    private String receiverPhoneNumber ;
    private String receiverAddress ;
    private String description ;
    private int quantity ;
}




