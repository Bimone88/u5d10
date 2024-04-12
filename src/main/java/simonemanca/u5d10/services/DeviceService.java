package simonemanca.u5d10.services;

import simonemanca.u5d10.entities.Dispositivo;
import simonemanca.u5d10.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Dispositivo> findAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Dispositivo> findDeviceById(UUID id) {
        return deviceRepository.findById(id);
    }

    public Dispositivo saveDevice(Dispositivo dispositivo) {
        return deviceRepository.save(dispositivo);
    }

    public void deleteDevice(UUID id) {
        deviceRepository.deleteById(id);
    }

}

