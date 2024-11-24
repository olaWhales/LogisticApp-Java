package org.example.data.repository;
import org.example.data.model.Receiver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends MongoRepository<Receiver, String> {
}
