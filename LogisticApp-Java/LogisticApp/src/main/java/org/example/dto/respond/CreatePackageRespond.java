package org.example.dto.respond;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreatePackageRespond {
    private String trackingLog;
    private String stuff;
    private String sender ;
    private String receiver ;
    private LocalDateTime createDate = LocalDateTime.now();
    private BigDecimal delivery = BigDecimal.ZERO;

}
