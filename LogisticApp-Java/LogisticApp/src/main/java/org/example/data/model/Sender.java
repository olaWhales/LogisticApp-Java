package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("SenderDetails")
public class Sender {
    @Id
    private String id ;
    private String phoneNumber ;
    private String name ;
}
