package org.example.data.repository;

import org.example.data.model.TrackingLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingLogRepository extends MongoRepository<TrackingLog, String> {

}
