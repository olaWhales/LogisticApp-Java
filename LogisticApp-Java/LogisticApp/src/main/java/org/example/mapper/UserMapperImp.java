package org.example.mapper;

import org.example.services.PackageService;
import org.example.services.ReceiverService;
import org.example.services.SenderService;
import org.example.services.TrackingLogService;

public class UserMapperImp implements UserMapper {

    @Override
    public ReceiverService getReceiverService() {
        getPackageService();
        return getReceiverService();
    }

    @Override
    public SenderService getSenderService() {
        getPackageService();
        return getSenderService();
    }

    @Override
    public TrackingLogService getTrackingLogService() {
        getPackageService();
        return getTrackingLogService();
    }

    @Override
    public PackageService getPackageService() {
        getReceiverService();
        return getPackageService();
    }
}
