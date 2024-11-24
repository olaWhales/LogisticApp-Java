package org.example.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTrackingLogRequest {
    private LocalDateTime trackingDateTime;
    private String trackingNumber;
    private String description;
}
