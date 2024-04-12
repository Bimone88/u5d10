package simonemanca.u5d10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simonemanca.u5d10.entities.Dispositivo;
import simonemanca.u5d10.services.DeviceService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {

    private final DeviceService deviceService;

    @Autowired
    public DispositivoController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<Dispositivo>> getAllDevices() {
        List<Dispositivo> dispositivi = deviceService.findAllDevices();
        return ResponseEntity.ok(dispositivi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDeviceById(@PathVariable UUID id) {
        return deviceService.findDeviceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDevice(@RequestBody Dispositivo dispositivo) {
        Dispositivo savedDispositivo = deviceService.saveDevice(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDevice(@PathVariable UUID id, @RequestBody Dispositivo dispositivo) {
        return deviceService.findDeviceById(id)
                .map(existingDispositivo -> {
                    dispositivo.setId(existingDispositivo.getId());
                    Dispositivo updatedDispositivo = deviceService.saveDevice(dispositivo);
                    return ResponseEntity.ok(updatedDispositivo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable UUID id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}

