package com.chipichapa.hospital.device.deviceController;

import com.chipichapa.hospital.exception.Exception;
import com.chipichapa.hospital.device.deviceModel.Device;
import com.chipichapa.hospital.device.deviceRepository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/device")
    public List<Device> getAllDevice(){
        return deviceRepository.findAll();
    }

    @PostMapping("/device")
    public Device createDevice(@RequestBody Device device){
        return deviceRepository.save(device);
    }

    @GetMapping("/medicine/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id){
        Device device = deviceRepository.findById(id).orElseThrow(() -> new Exception("Device not exist with id:" + id));
        return ResponseEntity.ok(device);
    }

    @PutMapping("/medicine/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails){
        Device device = deviceRepository.findById(id).orElseThrow(() -> new Exception("Device not exist with id:" + id));

        device.setMantenanceList(deviceDetails.getMantenanceList());
        device.setName(deviceDetails.getName());
        device.setStatus(deviceDetails.getStatus());

        Device updatedDevice = deviceRepository.save(device);

        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDevice(@PathVariable Long id){
        Device device = deviceRepository.findById(id).orElseThrow(() -> new Exception("Device not exist with id:" + id));
        deviceRepository.delete(device);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
