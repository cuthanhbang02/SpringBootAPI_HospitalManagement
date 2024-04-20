package com.chipichapa.hospital.device.deviceRepository;

import com.chipichapa.hospital.device.deviceModel.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long>{

}
