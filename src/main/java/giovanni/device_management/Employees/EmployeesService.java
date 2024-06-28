package giovanni.device_management.Employees;

import giovanni.device_management.Payloads.NewEmployeesDTO;
import giovanni.device_management.exceptions.BadRequestException;
import giovanni.device_management.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees saveNewEmployee (NewEmployeesDTO body) throws IOException {

       employeesRepository.findByEmail(body.email()).ifPresent(user -> {
           throw new BadRequestException("L'email " + body.email() + " risulta già utilizzata!");
       });
        Employees newEmployee = new Employees();
        newEmployee.setName(body.name());
        newEmployee.setSurname(body.surname());
        newEmployee.setUsername(body.username());
        newEmployee.setEmail(body.email());
        return employeesRepository.save(newEmployee);
    }

    public Employees findEmployeeById(long id){
        return employeesRepository.findById(id).orElseThrow(()-> new  NotFoundException(id));
    }

    public void findEmployeeByIdAndDelete(long id){
        Employees found = this.findEmployeeById(id);
        employeesRepository.delete(found);
    }

    
}
