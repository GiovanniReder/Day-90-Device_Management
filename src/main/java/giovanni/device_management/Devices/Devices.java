package giovanni.device_management.Devices;

import giovanni.device_management.Employees.Employees;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

    @Enumerated(EnumType.STRING)
    private DevicesStateEnum state;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

    public Devices( DevicesStateEnum state, String type) {
        this.state = state;
        this.type = type;
    }
}
