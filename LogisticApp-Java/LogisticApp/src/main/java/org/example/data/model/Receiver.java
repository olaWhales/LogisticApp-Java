package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ReceiverDetails")
public class Receiver {
    @Id
    private String id;
    private String fullName ;
    private String address ;
    private String phone;
}
