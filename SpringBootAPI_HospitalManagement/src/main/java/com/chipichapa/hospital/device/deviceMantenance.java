package com.chipichapa.hospital.device;

import jakarta.persistence.Entity;

@Entity
public class deviceMantenance {
    private String Date;

    private String Info;

    deviceMantenance(){}

    public deviceMantenance(String date, String info) {
        Date = date;
        Info = info;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
}
