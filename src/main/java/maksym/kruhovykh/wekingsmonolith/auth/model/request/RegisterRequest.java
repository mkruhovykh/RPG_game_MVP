package maksym.kruhovykh.wekingsmonolith.auth.model.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
