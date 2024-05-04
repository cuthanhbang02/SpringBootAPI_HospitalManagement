package com.chipichapa.hospital.staff.model;

import com.chipichapa.hospital.specialDepartment.model.SpecialDepartment;
import com.chipichapa.hospital.workShift.WorkShift;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Nurse extends Staff {
    @ManyToOne
    @JoinColumn(name="special_department_id", nullable=false)
    private SpecialDepartment special;

    @Column(name = "degree")
    private String degree;

    public Nurse() {};
    public Nurse(SpecialDepartment special, String degree) {
        this.special = special;
        this.degree = degree;
    }

    public Nurse(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts, SpecialDepartment special, String degree) {
        super(id, name, gender, dob, startDay, workShifts);
        this.special = special;
        this.degree = degree;
    }
}
