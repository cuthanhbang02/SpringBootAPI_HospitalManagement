package com.chipichapa.hospital.staff;

import com.chipichapa.hospital.specialDepartment.SpecialDepartment;
import jakarta.persistence.Column;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class SupportStaff extends Staff {
    @Id
    private long id;


    @Column(name = "name")
    private String name;
    @Column(name = "gender")

    private String gender;
    @Column(name = "dob")

    private LocalDate dob;
    @Column(name = "start_day")
    private LocalDate start_day;
    @Column(name = "position")
    private String position;
    public SupportStaff(){};
    public SupportStaff(long id, String fullName, LocalDate dateOfBirth, LocalDate start_day, String gender, String position)
    {this.id=id;
        this.name=fullName;
        this.dob=dateOfBirth;
        this.start_day=start_day;
        this.gender=gender;
        this.position=position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getStart_day() {
        return start_day;
    }

    public void setStart_day(LocalDate start_day) {
        this.start_day = start_day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPosition()
    {
        return this.position;
    }
    public void setPosition(String position)
    {this.position=position;}
}
