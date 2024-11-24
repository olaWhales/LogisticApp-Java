package org.example.mapper;

import org.example.services.PackageService;
import org.example.services.ReceiverService;
import org.example.services.SenderService;
import org.example.services.TrackingLogService;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    ReceiverService getReceiverService();
    SenderService getSenderService();
    TrackingLogService getTrackingLogService();
    PackageService getPackageService();
}
