package giovanni.device_management.Employees;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import giovanni.device_management.Devices.Devices;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "employees")

public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String name;

    private String surname;

    private String email;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Devices> devices;


    public Employees(String username, String name, String surname, String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}

