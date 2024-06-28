package giovanni.device_management.exceptions;


import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Record con id " + id + " non trovato!");
    }
}
