package maksym.kruhovykh.wekingsmonolith.mail.service;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mail.dto.MessageDto;
import maksym.kruhovykh.wekingsmonolith.mail.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(MessageDto messageDto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, messageDto);

    }
}
