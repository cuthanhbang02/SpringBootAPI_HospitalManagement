package com.chipichapa.hospital.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "device_id")
    private Set<DeviceMaintenance> mantenanceList;

    public Device(){}

    public Device(String status, String name) {
        super();
        this.status = status;
        this.name = name;
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

    public Set<DeviceMaintenance> getMaintenanceList() {
        return mantenanceList;
    }

    public void setMaintenanceList(Set<DeviceMaintenance> mantenanceList) {
        if (this.mantenanceList != null) {
            this.mantenanceList.clear();
            if (mantenanceList != null)
                this.mantenanceList.addAll(mantenanceList);
        }

    }
}
