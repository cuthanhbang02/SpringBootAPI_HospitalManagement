package com.chipichapa.hospital.sickness.model;

import com.chipichapa.hospital.medicalForm.model.MedicalForm;
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

    //constructor
    public Sickness(){}
    public Sickness(String sickName, Set<MedicalForm> medicalForms) {
        super();
        this.sickName = sickName;
        this.medicalForms = medicalForms;
    }

    //getter and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName;
    }

    public Set<MedicalForm> getMedicalForms() {
        return medicalForms;
    }

    public void setMedicalForms(Set<MedicalForm> medicalForms) {
        this.medicalForms = medicalForms;
    }
}
