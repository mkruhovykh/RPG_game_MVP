package maksym.kruhovykh.wekingsmonolith.mail.controller;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mail.dto.MessageDto;
import maksym.kruhovykh.wekingsmonolith.mail.service.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessagingController {

    private final MessageProducer messageProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto) {

        messageProducer.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent!");
    }
}