package giovanni.device_management.exceptions;


import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Employee with id " + id + " not found!");
    }
}
