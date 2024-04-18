package com.chipichapa.hospital.specialDepartment;

import com.chipichapa.hospital.staff.Doctor;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "special_department")
public class SpecialDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String specialist;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "special")
    private Set<Doctor> doctors;


}
