package giovanni.device_management.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewEmployeesDTO(

        // LA SIZE E' OPZIONALE, L'HO MESSA SOLO PER FAR PRATICA

        @NotEmpty(message = "L'username è un dato obbligatorio!")
        @Size(min = 4, message = "L'username deve avere almeno 4 caratteri!")
        String username,

        @NotEmpty(message = "Il nome proprio è un dato obbligatorio!")
        @Size(min = 3, max = 25, message = "Il nome proprio deve essere compreso tra i 3 ed i 25 caratteri!")
        String name,

        @NotEmpty(message = "Il cognome è un dato obbligatorio!")
        @Size(min = 3, max = 25, message = "Il cognome deve essere compreso tra i 3 ed i 25 caratteri!")
        String surname,

        @NotEmpty(message = "L'email è un dato obbligatorio!")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email

        )

{
}
