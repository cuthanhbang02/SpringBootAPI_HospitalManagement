package com.chipichapa.hospital.medicalForm;

import com.chipichapa.hospital.sickness.Sickness;
import com.chipichapa.hospital.staff.Doctor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "medical_form")
public class MedicalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDateTime time;

    @Column
    private String status;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "form_sickness", joinColumns = @JoinColumn(name = "medical_form_id"), inverseJoinColumns = @JoinColumn(name = "sickness_id"))
    private Set<Sickness> sicknesses = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
