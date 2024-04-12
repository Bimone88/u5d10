package simonemanca.u5d10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simonemanca.u5d10.entities.Dipendente;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Dipendente, UUID> {
    // metodi di ricerca che potrei mettere più VANTI
}

// POTEVO CHIAMARLI ANCHE DAO