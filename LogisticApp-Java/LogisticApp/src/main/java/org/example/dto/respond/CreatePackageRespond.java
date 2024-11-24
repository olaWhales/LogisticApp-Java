package org.example.dto.respond;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePackageRespond {
    private String trackingNumber;
    private String stuff;
    private String sender ;
    private String receiver ;
    private LocalDateTime createDate = LocalDateTime.now();
}
