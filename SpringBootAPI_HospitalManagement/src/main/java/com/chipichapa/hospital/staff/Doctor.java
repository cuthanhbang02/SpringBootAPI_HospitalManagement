package com.chipichapa.hospital.staff;

import com.chipichapa.hospital.specialDepartment.SpecialDepartment;
import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="special_department_id", nullable=false)
    private SpecialDepartment special;
}
