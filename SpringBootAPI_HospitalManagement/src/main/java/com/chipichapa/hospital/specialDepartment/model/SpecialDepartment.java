package com.chipichapa.hospital.specialDepartment.model;

import com.chipichapa.hospital.staff.model.Doctor;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "special")
    private Set<Doctor> doctors;

    public SpecialDepartment(){

    }

    public SpecialDepartment(String name, String specialist, Set<Doctor> doctors) {
        super();
        this.name = name;
        this.specialist = specialist;
        this.doctors = doctors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
