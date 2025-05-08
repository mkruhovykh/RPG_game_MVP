package maksym.kruhovykh.wekingsmonolith.mail.repository.mysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import maksym.kruhovykh.wekingsmonolith.mail.dto.MessageStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private MessageStatus status;
}