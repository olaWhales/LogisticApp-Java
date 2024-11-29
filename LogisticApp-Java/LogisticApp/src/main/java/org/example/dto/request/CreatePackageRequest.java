package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Receiver;
import org.example.data.model.Sender;

@Data
public class CreatePackageRequest {
    private Receiver receiverFullName ;
    private Receiver receiverPhoneNumber ;
    private Receiver receiverAddress ;
    private Sender senderFullName ;
    private Sender senderPhoneNumber ;
    private String description ;
    private int quantity ;

}




