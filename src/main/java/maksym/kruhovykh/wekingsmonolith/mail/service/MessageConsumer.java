package maksym.kruhovykh.wekingsmonolith.mail.service;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mail.dto.MessageDto;
import maksym.kruhovykh.wekingsmonolith.mail.config.RabbitMQConfig;
import maksym.kruhovykh.wekingsmonolith.mail.dto.MessageStatus;
import maksym.kruhovykh.wekingsmonolith.mail.repository.mongo.MessageContent;
import maksym.kruhovykh.wekingsmonolith.mail.repository.mongo.MessageContentRepository;
import maksym.kruhovykh.wekingsmonolith.mail.repository.mysql.MessageEntity;
import maksym.kruhovykh.wekingsmonolith.mail.repository.mysql.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private final MessageRepository messageRepository;

    private final MessageContentRepository messageContentRepository;
    private SimpMessagingTemplate messagingTemplate; // Для отправки уведомлений через WebSocket

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessage(MessageDto messageDTO) {
        // Сохраняем метаданные в MySQL
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setSenderId(messageDTO.getSenderId());
        messageEntity.setReceiverId(messageDTO.getReceiverId());
        messageEntity.setTimestamp(LocalDateTime.now());
        messageEntity.setStatus(MessageStatus.UNREAD);
        messageEntity = messageRepository.save(messageEntity);

        MessageContent messageContent = new MessageContent();
        messageContent.setMessageId(messageEntity.getId());
        messageContent.setContent(messageDTO.getContent());
        messageContentRepository.save(messageContent);

        messagingTemplate.convertAndSend("/topic/user/" + messageDTO.getReceiverId(), messageDTO);

    }
}
