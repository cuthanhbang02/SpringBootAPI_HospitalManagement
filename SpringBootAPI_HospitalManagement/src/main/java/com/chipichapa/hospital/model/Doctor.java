package com.chipichapa.hospital.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Doctor extends Staff {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="special_department_id")
    private SpecialDepartment special;

    @Column(name = "degree")
    private String degree;

    public Doctor() {};
    public Doctor(SpecialDepartment special, String degree) {
        this.special = special;
        this.degree = degree;
    }

    public Doctor(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts, SpecialDepartment special, String degree) {
        super(id, name, gender, dob, startDay, workShifts);
        this.special = special;
        this.degree = degree;
    }
}
