package com.chipichapa.hospital.device.deviceModel;

import jakarta.persistence.*;
import com.chipichapa.hospital.device.DeviceMaintenance;

import java.util.List;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @OneToMany
    @Column(name = "maintenance_list")
    private List<DeviceMaintenance> mantenanceList;

    public Device(){}

    public Device(String status, String name, List<DeviceMaintenance> mantenanceList) {
        super();
        this.status = status;
        this.name = name;
        this.mantenanceList = mantenanceList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeviceMaintenance> getMaintenanceList() {
        return mantenanceList;
    }

    public void setMaintenanceList(List<DeviceMaintenance> mantenanceList) {
        this.mantenanceList = mantenanceList;
    }
}
