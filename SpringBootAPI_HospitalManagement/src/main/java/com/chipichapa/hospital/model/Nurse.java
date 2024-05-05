package com.chipichapa.hospital.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Nurse extends Staff {
    @Column(name = "special")
    String special;

    @Column(name = "degree")
    private String degree;

    public Nurse() {};
    public Nurse(String special, String degree) {
        this.special = special;
        this.degree = degree;
    }

    public Nurse(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts, String special, String degree) {
        super(id, name, gender, dob, startDay, workShifts);
        this.special = special;
        this.degree = degree;
    }
}
