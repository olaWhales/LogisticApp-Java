package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document ("TrackingLogDetails")
public class TrackingLog {
    @Id
    private String id ;
    private LocalDateTime trackingDate;
    private String description;
    private String trackingNumber ;

}
