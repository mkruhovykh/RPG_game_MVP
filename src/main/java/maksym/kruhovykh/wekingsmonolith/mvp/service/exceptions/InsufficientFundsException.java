package maksym.kruhovykh.wekingsmonolith.mvp.service.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}