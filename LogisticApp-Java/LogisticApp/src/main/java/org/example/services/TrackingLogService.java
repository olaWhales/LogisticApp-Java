package org.example.services;

import org.example.dto.request.CreateTrackingLogRequest;
import org.example.dto.respond.CreateTrackingLogRespond;


public interface TrackingLogService {
    CreateTrackingLogRespond createTrackingLogRespond(CreateTrackingLogRequest createTrackingLogRequest);
}
