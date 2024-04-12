package simonemanca.u5d10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simonemanca.u5d10.entities.Dispositivo;
import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Dispositivo, UUID> {
   
}

