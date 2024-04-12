package simonemanca.u5d10.services;

import simonemanca.u5d10.entities.Dipendente;
import simonemanca.u5d10.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Dipendente> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Dipendente> findEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    public Dipendente saveEmployee(Dipendente dipendente) {
        return employeeRepository.save(dipendente);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

}

