package com.chipichapa.hospital.sickness;

import com.chipichapa.hospital.medicalForm.MedicalForm;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name = "sickness")
public class Sickness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String sickName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "sicknesses")
    @JsonIgnore
    private Set<MedicalForm> medicalForms = new HashSet<>();
}
