package giovanni.device_management.Devices;

import giovanni.device_management.Employees.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevicesRepository extends JpaRepository<Devices , Long> {

    Optional<Devices> findById(long id);
}
