package maksym.kruhovykh.wekingsmonolith.mail.repository.mongo;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messageContent")
@Getter
@Setter
public class MessageContent {
    @Id
    private String id;

    private Long messageId;
    private String content;

}
