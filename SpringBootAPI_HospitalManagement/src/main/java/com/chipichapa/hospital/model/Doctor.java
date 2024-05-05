package com.chipichapa.hospital.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Doctor extends Staff {
    @Column(name = "degree")
    private String degree;

    @Column(name = "special")
    private String special;

    public Doctor() {};
    public Doctor(String special, String degree) {
        super();
        this.special = special;
        this.degree = degree;
    }

    public Doctor(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts, String special, String degree) {
        super(id, name, gender, dob, startDay, workShifts);
        this.special = special;
        this.degree = degree;
    }
}
