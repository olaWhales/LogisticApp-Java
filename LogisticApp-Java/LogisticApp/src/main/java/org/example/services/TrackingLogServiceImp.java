package org.example.services;

import org.example.data.model.TrackingLog;
import org.example.data.repository.TrackingLogRepository;
import org.example.dto.request.CreateTrackingLogRequest;
import org.example.dto.respond.CreateTrackingLogRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingLogServiceImp implements TrackingLogService {
    TrackingLogService trackingLogService;
    @Autowired
    TrackingLogRepository trackingLogRepository;

    public CreateTrackingLogRespond respond(CreateTrackingLogRequest request) {
        CreateTrackingLogRespond respond = new CreateTrackingLogRespond();
        trackingLogService = new TrackingLogServiceImp();
        TrackingLog trackingLog = new TrackingLog();
        trackingLog.setTrackingNumber(request.getTrackingNumber());
        trackingLog.setTrackingDate(request.getTrackingDateTime());
        trackingLog.setDescription(request.getDescription());
        trackingLogRepository.save(trackingLog);
        respond.setMessage("Details is intact");
        return respond;

    }
}
