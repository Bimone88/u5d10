package simonemanca.u5d10.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import simonemanca.u5d10.entities.Dipendente;
import simonemanca.u5d10.repositories.EmployeeRepository;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAllEmployees() {
        Dipendente dipendente = new Dipendente("username", "Nome", "Cognome", "email@example.com");
        Mockito.when(employeeRepository.findAll()).thenReturn(Collections.singletonList(dipendente));

        assertThat(employeeService.findAllEmployees()).containsExactly(dipendente);
    }


}
