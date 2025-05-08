package maksym.kruhovykh.wekingsmonolith.mail.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageContentRepository extends MongoRepository<MessageContent, String> {
}
