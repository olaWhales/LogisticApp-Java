package org.example.data.repository;
import org.example.data.model.Receiver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiverRepository extends MongoRepository<Receiver, String> {
//    Receiver findByName(String fullName);
}
