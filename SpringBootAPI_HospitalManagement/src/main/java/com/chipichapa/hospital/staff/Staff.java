package com.chipichapa.hospital.staff;

import com.chipichapa.hospital.workShift.WorkShift;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public  class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "staff_work_shift",
            joinColumns =
                    { @JoinColumn(name = "staff_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "work_shift_id", referencedColumnName = "id") })
    private WorkShift workShifts;

}
