package org.example.services;

import org.example.data.model.TrackingLog;
import org.example.data.repository.TrackingLogRepository;
import org.example.dto.request.CreateTrackingLogRequest;
import org.example.dto.respond.CreateTrackingLogRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.example.Util.Mapper.map;

@Service
public class TrackingLogServiceImp implements TrackingLogService {
    TrackingLogService trackingLogService;
    @Autowired
    TrackingLogRepository trackingLogRepository;

    List<TrackingLog> trackingLogs = new ArrayList<>();

    @Override
    public CreateTrackingLogRespond createTrackingLogRespond (CreateTrackingLogRequest createTrackingLogRequest) {
        TrackingLog trackingLog = new TrackingLog();
        trackingLog.setTrackingNumber(createTrackingLogRequest.getTrackingNumber());
        trackingLog.setDescription(createTrackingLogRequest.getDescription());
        trackingLog.setTrackingDate(createTrackingLogRequest.getTrackingDateTime());
        trackingLogs.add(trackingLog);
        trackingLogRepository.save(trackingLog);
        CreateTrackingLogRespond createTrackingLogRespond = new CreateTrackingLogRespond();
        createTrackingLogRespond.setMessage("Details successfully added");
        return createTrackingLogRespond;
    }
}
