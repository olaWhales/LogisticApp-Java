package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Receiver;
@Data
public class CreateReceiverRequest {
    private String receiverName;
    private String receiverAddress;
    private String phoneNumber;
}
