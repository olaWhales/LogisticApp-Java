package org.example.dto.request;

import lombok.Data;

@Data
public class CreateSenderRequest {
    private String senderName;
    private String phoneNumber;
    private String address ;
}
