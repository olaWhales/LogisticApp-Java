package org.example.data.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Document("packageDetails")
public class Package {
    @Id
    private String id;
    private String description;
    private LocalDateTime creationAt;
    private int quantity ;
    private BigDecimal deliveryFee ;
    @DBRef
    private Sender sender;
    @DBRef
    private Receiver receiver;
    @DBRef
    private List<TrackingLog> trackingLog;
}


