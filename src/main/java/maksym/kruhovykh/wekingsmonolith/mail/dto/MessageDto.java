package maksym.kruhovykh.wekingsmonolith.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageDto implements Serializable {
    private Long senderId;
    private Long receiverId;
    private String content;
    private String status;


}