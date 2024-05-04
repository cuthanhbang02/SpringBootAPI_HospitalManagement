package com.chipichapa.hospital.patient.model;

import com.chipichapa.hospital.medicalForm.model.MedicalForm;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private long id;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String dateOfBirth;

    @Column
    private String phoneNumber;

    @Column
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private List<MedicalForm> medicalForms;

    //Constructor
    public Patient(){}
    public Patient(long id, String fullName, String address, String dateOfBirth, String phoneNumber, String gender, List<MedicalForm> medicalForms) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.medicalForms = medicalForms;
    }

    //getter and setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<MedicalForm> getMedicalForms() {
        return medicalForms;
    }

    public void setMedicalForms(List<MedicalForm> medicalForms) {
        this.medicalForms = medicalForms;
    }

    //other method

}
