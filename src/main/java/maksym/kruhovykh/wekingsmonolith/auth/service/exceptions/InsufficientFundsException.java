package maksym.kruhovykh.wekingsmonolith.auth.service.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}