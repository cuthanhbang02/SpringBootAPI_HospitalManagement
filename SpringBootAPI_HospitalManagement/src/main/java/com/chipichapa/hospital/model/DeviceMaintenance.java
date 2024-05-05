package com.chipichapa.hospital.model;

import jakarta.persistence.*;

@Entity
public class DeviceMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String date;

    @Column
    private String info;

    public DeviceMaintenance(long id, String date, String info) {
        id = id;
        date = date;
        info = info;
    }

    public DeviceMaintenance() {

    }

    public String getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        info = info;
    }
}
