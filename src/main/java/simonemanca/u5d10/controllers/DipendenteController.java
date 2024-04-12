package simonemanca.u5d10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simonemanca.u5d10.entities.Dipendente;
import simonemanca.u5d10.services.EmployeeService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    private final EmployeeService employeeService;

    @Autowired
    public DipendenteController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAllEmployees() {
        List<Dipendente> dipendenti = employeeService.findAllEmployees();
        return ResponseEntity.ok(dipendenti);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getEmployeeById(@PathVariable UUID id) {
        return employeeService.findEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dipendente> createEmployee(@RequestBody Dipendente dipendente) {
        Dipendente savedDipendente = employeeService.saveEmployee(dipendente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDipendente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateEmployee(@PathVariable UUID id, @RequestBody Dipendente dipendente) {
        return employeeService.findEmployeeById(id)
                .map(existingDipendente -> {
                    dipendente.setId(existingDipendente.getId());
                    Dipendente updatedDipendente = employeeService.saveEmployee(dipendente);
                    return ResponseEntity.ok(updatedDipendente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

