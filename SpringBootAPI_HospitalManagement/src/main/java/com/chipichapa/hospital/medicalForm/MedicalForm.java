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

    //constructor

    public  MedicalForm(){}
    public MedicalForm(long id, LocalDateTime time, String status, Set<Sickness> sicknesses, Doctor doctor) {
        this.id = id;
        this.time = time;
        this.status = status;
        this.sicknesses = sicknesses;
        this.doctor = doctor;
    }

    //getter and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Sickness> getSicknesses() {
        return sicknesses;
    }

    public void setSicknesses(Set<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
