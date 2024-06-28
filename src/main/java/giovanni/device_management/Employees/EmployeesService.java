package giovanni.device_management.Employees;

import giovanni.device_management.Payloads.NewEmployeesDTO;
import giovanni.device_management.exceptions.BadRequestException;
import giovanni.device_management.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Page<Employees> getEmployees(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 100) pageSize = 100;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return employeesRepository.findAll(pageable);
    }


    public Employees saveNewEmployee (NewEmployeesDTO body) throws IOException {

       employeesRepository.findByEmail(body.email()).ifPresent(user -> {
           throw new BadRequestException("L'email " + body.email() + " risulta già utilizzata!");
       });
        Employees newEmployee = new Employees(body.username(), body.name(), body.surname(), body.email());
        return employeesRepository.save(newEmployee);
    }

    public Employees findEmployeeById(long id){
        return employeesRepository.findById(id).orElseThrow(()-> new  NotFoundException(id));
    }

    public Employees findEmployeeByIdAndUpdate(long id , Employees modifiedEmployee){
        Employees found = this.findEmployeeById(id);
        found.setName(modifiedEmployee.getName());
        found.setSurname(modifiedEmployee.getSurname());
        found.setUsername(modifiedEmployee.getUsername());
        found.setEmail(modifiedEmployee.getEmail());
        return employeesRepository.save(found);
    }


    public void findEmployeeByIdAndDelete(long id){
        Employees found = this.findEmployeeById(id);
        employeesRepository.delete(found);
    }


}
