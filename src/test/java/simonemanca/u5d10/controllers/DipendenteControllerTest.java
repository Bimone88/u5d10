package simonemanca.u5d10.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import simonemanca.u5d10.entities.Dipendente;
import simonemanca.u5d10.services.EmployeeService;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DipendenteController.class)
public class DipendenteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() throws Exception {
        Dipendente dipendente = new Dipendente("username", "Nome", "Cognome", "email@example.com");
        Mockito.when(employeeService.findAllEmployees()).thenReturn(Collections.singletonList(dipendente));

        mockMvc.perform(get("/api/dipendenti"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].username").value(dipendente.getUsername()));
    }


}
