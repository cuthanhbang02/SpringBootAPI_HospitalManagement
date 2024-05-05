package com.chipichapa.hospital.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SupportStaff extends Staff {
    @Column(name = "position")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public SupportStaff(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts, String position) {
        super(id, name, gender, dob, startDay, workShifts);
        this.position = position;
    }

    public SupportStaff(String position) {
        super();
        this.position = position;
    }

    public SupportStaff() {
        super();
    };
}
